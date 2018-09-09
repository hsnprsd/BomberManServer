package ir.bomberman.game;

import ir.bomberman.game.entities.Entity;
import ir.bomberman.game.map.Map;
import ir.bomberman.game.map.MapCreator;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private State state = State.WAITING;

    private List<Entity> entities = new ArrayList<>();

    public Game(int nPlayers) {
        Map map = MapCreator.create(nPlayers);
        for (int x = 0; x < map.getWidth(); ++x) {
            for (int y = 0; y < map.getHeight(); ++y) {
                entities.add(map.getInstance(x, y));
            }
        }
    }

    public void step() {
        for (Entity entity : entities) {
            entity.step();
        }
    }

    public State getState() {
        return state;
    }

    public enum State {
        WAITING, RUNNING, STOPPED, ENDED
    }
}
