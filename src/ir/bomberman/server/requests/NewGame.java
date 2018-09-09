package ir.bomberman.server.requests;

public class NewGame extends Request {
    private int nPlayers;

    NewGame() {
        super(Type.NEW_GAME);
    }

    public int getNumOfPlayers() {
        return nPlayers;
    }
}
