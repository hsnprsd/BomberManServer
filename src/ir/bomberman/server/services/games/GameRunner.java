package ir.bomberman.server.services.games;

import ir.bomberman.game.Game;
import ir.bomberman.server.Player;
import ir.bomberman.server.services.games.utils.GameFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameRunner {
    private int nPlayers;
    private List<Player> players = new ArrayList<>();

    private Game game;
    private Thread gameThread;

    public GameRunner(int nPlayers) {
        this.nPlayers = nPlayers;
        game = new Game(nPlayers);
    }

    public boolean newPlayer(Player player) {
        if (game.getState() != Game.State.WAITING) {
            return false;
        }
        players.add(player);
        if (players.size() == nPlayers) {
            startGame();
        }
        return true;
    }

    private void startGame() {
        if (gameThread != null) {
            throw new IllegalStateException();
        }
        gameThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                Date startDate = new Date();
                game.step();
                Date endDate = new Date();
                try {
                    Thread.sleep(20 - (endDate.getTime() - startDate.getTime()));
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        gameThread.start();
    }

    public String getGameState() {
        return GameFormatter.toJson(game);
    }

    public Game.State getState() {
        return game.getState();
    }
}
