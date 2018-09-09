package ir.bomberman.game.entities;

import ir.bomberman.game.geometry.Span;

public abstract class Entity {
    private Type type;

    private Span span;

    Entity(int cellX, int cellY, Type type) {
        int cellSize = 0;
        span = new Span(cellX * cellSize, cellY * cellSize, cellSize);

        this.type = type;
    }

    public Span getSpan() {
        return span;
    }

    public void step() {
    }

    public enum Type {
        BOMBERMAN, ENEMY, BOMB, WALL, BLOCK
    }
}
