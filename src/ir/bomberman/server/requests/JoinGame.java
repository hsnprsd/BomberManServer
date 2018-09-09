package ir.bomberman.server.requests;

public class JoinGame extends Request {
    private String token;

    JoinGame() {
        super(Type.JOIN_GAME);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
