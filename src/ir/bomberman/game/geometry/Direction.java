package ir.bomberman.game.geometry;

public enum Direction {
    UP(0, -1), RIGHT(1, 0), LEFT(-1, 0), DOWN(0, 1);

    private int dx, dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
