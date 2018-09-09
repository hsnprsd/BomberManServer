package ir.bomberman.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class PlayerListener {
    private Player player;
    private Server server;

    private DataInputStream input;
    private DataOutputStream output;

    private Thread listeningThread;

    public PlayerListener(Player player, Server server) throws IOException {
        this.player = player;
        this.server = server;

        Socket socket = player.getSocket();
        output = new DataOutputStream(socket.getOutputStream());
        input = new DataInputStream(socket.getInputStream());
    }

    public synchronized void listen() {
        if (listeningThread != null) {
            throw new IllegalStateException();
        }
        listeningThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = input.readUTF();
                    server.newMessage(player, message);
                } catch (IOException e) {
                    break;
                }
            }
        });
        listeningThread.start();
    }

    public boolean send(String message) {
        try {
            output.writeUTF(message);
            output.flush();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void stop() {
        if (listeningThread == null) {
            throw new IllegalStateException();
        }
        listeningThread.interrupt();
        listeningThread = null;
    }

    public boolean isConnected() {
        return player.getSocket().isConnected();
    }
}
