package ir.bomberman.server;

import java.net.Socket;

public class Player {
    private Socket socket;

    private String name;

    public Player(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getName() {
        if (name == null) {
            return "guest";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
