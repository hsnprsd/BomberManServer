package ir.bomberman.game.map;

import ir.bomberman.game.entities.Entity;

public class MapCreator {
    public static Map create(int nPlayers) {
//        TODO responsive map size according to num of players
        int width = 9;
        int height = 9;
        Map map = new Map(width, height);
        for (int x = 0; x < width; x += 2) {
            for (int y = 0; y < height; y += 2) {
                map.setCell(x, y, Entity.Type.BLOCK);
            }
        }
        return map;
    }
}
