package ir.bomberman.game.entities;

import ir.bomberman.game.entities.behaviours.Movable;
import ir.bomberman.game.geometry.Direction;

public abstract class MoverEntity extends Entity implements Movable {
    private Direction direction;

    MoverEntity(int cellX, int cellY, Type type) {
        super(cellX, cellY, type);
    }

    @Override
    public void move() {
        if (direction == null) {
            return;
        }
    }

    @Override
    public void step() {
        move();
    }
}
