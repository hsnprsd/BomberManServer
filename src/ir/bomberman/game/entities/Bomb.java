package ir.bomberman.game.entities;

import ir.bomberman.game.Settings;

public class Bomb extends Entity {
    private int ticks = 0;
    private boolean exploded = false;

    Bomb(int cellX, int cellY) {
        super(cellX, cellY, Type.BOMB);
    }

    @Override
    public void step() {
        if (!isExploded()) {
            ticks += 1;
            if (ticks == Settings.Bomb.TICKS) {
                explode();
            }
        }
    }

    private void explode() {
        exploded = true;
    }

    public boolean isExploded() {
        return exploded;
    }
}
