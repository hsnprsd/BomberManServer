package ir.bomberman.server.services.games;

import ir.bomberman.server.Player;
import ir.bomberman.server.services.games.utils.TokenGenerator;

import java.util.HashMap;

public class GameService {
    private HashMap<String, GameRunner> gameRunners = new HashMap<>();

    public String newGame(int nPlayers) {
        String token = TokenGenerator.generate(20);
        gameRunners.put(token, new GameRunner(nPlayers));
        return token;
    }

    public String getGameState(String token) {
        if (!gameRunners.containsKey(token)) {
            throw new IllegalArgumentException();
        }
        GameRunner runner = gameRunners.get(token);
        return runner.getGameState();
    }

    public void joinGame(String token, Player player) {
        if (!gameRunners.containsKey(token)) {
            throw new IllegalArgumentException();
        }
        GameRunner runner = gameRunners.get(token);
        runner.newPlayer(player);
    }
}
