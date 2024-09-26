package nationswaltz.territory;

import nationswaltz.map.*;
import nationswaltz.nation.*;


/**
 * @author Wester
 */
public abstract class Territory {

    private Nation _nation;
    private final Cell _cell;
    private final Map _map;
    private int _soldier;
    private int _income;

    public Territory(Cell cell, Map map) {
        _cell = cell;
        _map = map;
    }
    
    public Map getMap() {
    	return _map;
    }

    public Cell getCell() {
        return _cell;
    }

    public int getIncome() {
        return _income;
    }

    public void setIncome(int income) {
        _income = income;
    }

    public void addIncome(int amount) {
        _income += amount;
    }

    public Nation getNation() {
        return _nation;
    }

    public void setNation(Nation nation) {
        if (_nation != null) {
            _nation.remove(this);
        }
        _nation = nation;
        _nation.add(this);
    }

    public int getSoldier() {
        return _soldier;
    }

    public void setSoldier(int soldier) {
        _soldier = soldier;
    }

    public void addSoldier(int amount) {
        _soldier += amount;
    }

    public boolean attack(Territory territory, int soldier) {
        _soldier -= soldier;
        territory.addSoldier(-soldier);
        if (territory.getSoldier() < 0) {
            territory.setSoldier(-territory.getSoldier());
            territory.setNation(_nation);
            return true;
        }
        return false;
    }

    public abstract boolean isLand();

}

