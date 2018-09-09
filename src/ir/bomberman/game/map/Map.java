package ir.bomberman.game.map;

import ir.bomberman.game.entities.*;

public class Map {
    private int width;
    private int height;

    private Entity.Type[][] cells;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        cells = new Entity.Type[width][height];
    }

    public void setCell(int x, int y, Entity.Type type) {
        if (!isInMap(x, y)) {
            throw new IllegalArgumentException();
        }
        cells[x][y] = type;
    }

    public Entity.Type getCell(int x, int y) {
        if (!isInMap(x, y)) {
            throw new IllegalArgumentException();
        }
        return cells[x][y];
    }

    public Entity getInstance(int x, int y) {
        switch (cells[x][y]) {
            case BOMBERMAN:
                return new BomberMan(x, y);
            case ENEMY:
                return new Enemy(x, y);
            case WALL:
                return new Wall(x, y);
            case BLOCK:
                return new Block(x, y);
        }
        return null;
    }

    private boolean isInMap(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
