package ir.bomberman.game.geometry;

public class Span {
    private Point p, q;

    public Span(int x1, int y1, int x2, int y2) {
        p = new Point(x1, y1);
        q = new Point(x2, y2);
    }

    public Span(int x, int y, int size) {
        p = new Point(x, y);
        q = new Point(x + size, y + size);
    }

    private Span(Point p, Point q) {
        this.p = p;
        this.q = q;
    }

    public void move(int dx, int dy) {
        p.move(dx, dy);
        q.move(dx, dy);
    }
}
