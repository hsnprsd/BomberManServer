package ir.bomberman.server.services.games.utils;

import java.util.Random;

public class TokenGenerator {
    private static Random random = new Random();

    public static String generate(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            builder.append((char) (random.nextInt(26) + (int) ('a')));
        }
        return builder.toString();
    }
}
