package ir.bomberman.game.entities;

public class Wall extends Entity {
    public Wall(int cellX, int cellY) {
        super(cellX, cellY, Type.WALL);
    }
}
