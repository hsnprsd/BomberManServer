package ir.bomberman.game.entities;

public class Enemy extends MoverEntity {
    public Enemy(int cellX, int cellY) {
        super(cellX, cellY, Type.ENEMY);
    }
}
