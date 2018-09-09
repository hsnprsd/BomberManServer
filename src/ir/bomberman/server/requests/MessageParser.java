package ir.bomberman.server.requests;

import com.google.gson.Gson;

public class MessageParser {
    public static Request parse(String message) {
        Gson gson = new Gson();
        Request request = gson.fromJson(message, Request.class);
        switch (request.getType()) {
            case GET_GAME_STATE:
                return gson.fromJson(message, GetGameState.class);
            case NEW_GAME:
                return gson.fromJson(message, NewGame.class);
            case JOIN_GAME:
                return gson.fromJson(message, JoinGame.class);
        }
        return null;
    }
}
