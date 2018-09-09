package ir.bomberman.game;

public interface Settings {
    interface Game {
        int FPS = 60;
    }

    interface Bomb {
        int TICKS = Game.FPS * 5;
    }
}
