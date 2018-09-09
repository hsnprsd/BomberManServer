package ir.bomberman.server.requests;

public abstract class Request {
    private Type type;

    Request(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        GET_GAME_STATE, NEW_GAME, JOIN_GAME
    }
}
