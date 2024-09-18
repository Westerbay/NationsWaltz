package nationswaltz.player;

import nationswaltz.nation.Nation;

public class Player {

    private final Nation _nation;

    public Player(Nation nation) {
        _nation = nation;
    }

    public Nation getNation() {
        return _nation;
    }

    public void endTurn() {
        _nation.endTurn();
    }

}
