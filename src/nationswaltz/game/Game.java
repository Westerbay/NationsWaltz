package nationswaltz.game;

import nationswaltz.player.Player;
import nationswaltz.map.Map;

import java.util.HashSet;

public class Game extends HashSet<Player> {

    private final Map _map;

    public Game() {
        _map = new Map(200, 800, 800);
    }

    public Map getMap() {
        return _map;
    }

    public boolean end() {
        return size() == 1;
    }

    public void eliminatePlayer(Player player) {
        remove(player);
    }

    public void endTurn() {
        for (Player player : this) {
            player.endTurn();
        }
        for (Player player : this) {
            if (player.getNation().isEmpty()) {
                eliminatePlayer(player);
            }
        }
    }

    public void start() {
        while (!end()) {
            endTurn();
        }
    }

}
