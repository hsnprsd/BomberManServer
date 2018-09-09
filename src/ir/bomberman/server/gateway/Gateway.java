package ir.bomberman.server.gateway;

import ir.bomberman.server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Gateway {
    private int port;
    private Server server;

    private ServerSocket serverSocket;

    private Thread listeningThread;

    public Gateway(int port, Server server) throws IOException {
        this.port = port;
        this.server = server;

        serverSocket = new ServerSocket(port);
    }

    public void listen() {
        if (listeningThread != null) {
            throw new IllegalStateException();
        }
        listeningThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Socket socket = serverSocket.accept();
                    server.newPlayer(socket);
                } catch (IOException e) {
                    break;
                }
            }
        });
        listeningThread.start();
    }

    public void stop() {
        if (listeningThread == null) {
            throw new IllegalStateException();
        }
        listeningThread.interrupt();
        listeningThread = null;
    }
}
