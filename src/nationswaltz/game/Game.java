package nationswaltz.game;

import nationswaltz.player.Player;
import nationswaltz.map.Map;
import nationswaltz.nation.Nation;

import java.util.*;

public class Game {

    private final Map _map;
    private final int _numberOfPlayer;
    private final List<Nation> _nations = new ArrayList<>();

    public Game() {
        _map = new Map(200, 720, 720);
        _numberOfPlayer = 8;
        generatePlayers();
    }

    public Map getMap() {
        return _map;
    }
    
    public void generatePlayers() {
    	for (int i = 0; i < _numberOfPlayer; i ++) {
    		_nations.add(new Nation());
    	}
    	_map.setCapitals(_nations);
    }

}

