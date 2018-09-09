package ir.bomberman.server;

import ir.bomberman.server.gateway.Gateway;
import ir.bomberman.server.requests.GetGameState;
import ir.bomberman.server.requests.JoinGame;
import ir.bomberman.server.requests.MessageParser;
import ir.bomberman.server.requests.Request;
import ir.bomberman.server.services.games.GameService;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    private Gateway gateway;

    private GameService gameService;
    private HashMap<Player, PlayerListener> players = new HashMap<>();

    private Server(int port) throws IOException {
        gateway = new Gateway(port, this);
        gameService = new GameService();
    }

    public void newPlayer(Socket socket) {
        Player player = new Player(socket);
        try {
            PlayerListener listener = new PlayerListener(player, this);
            players.put(player, listener);
        } catch (IOException ignored) {
        }
    }

    public synchronized void newMessage(Player player, String message) {
        Request request = MessageParser.parse(message);
        if (request == null) {
            return;
        }
        String result;
        switch (request.getType()) {
            case GET_GAME_STATE:
                result = gameService.getGameState(((GetGameState) request).getToken());
                break;
            case NEW_GAME:
                result = gameService.newGame();
                break;
            case JOIN_GAME:
                result = gameService.joinGame(((JoinGame) request).getToken(), player);
                break;
        }
        players.get(player).send(result);
    }

    private void start() {
        gateway.listen();
    }

    public void stop() {
        gateway.stop();
    }

    public static void main(String[] args) throws IOException {
        new Server(8000).start();
    }
}
