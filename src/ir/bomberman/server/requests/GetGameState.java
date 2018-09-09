package ir.bomberman.server.requests;

public class GetGameState extends Request {
    private String token;

    public GetGameState() {
        super(Type.GET_GAME_STATE);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
