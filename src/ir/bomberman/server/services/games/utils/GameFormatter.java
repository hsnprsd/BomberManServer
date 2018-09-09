package ir.bomberman.server.services.games.utils;

import com.google.gson.Gson;
import ir.bomberman.game.Game;

public class GameFormatter {
    public static String toJson(Game game) {
        Gson gson = new Gson();
        return gson.toJson(game);
    }
}
