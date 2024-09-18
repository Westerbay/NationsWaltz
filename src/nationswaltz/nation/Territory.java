package nationswaltz.nation;

import nationswaltz.map.Cell;

public class Territory {

    private Nation _nation;
    private final Cell _cell;
    private int _soldier;
    private int _income;

    public Territory(Cell cell) {
        _cell = cell;
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

    public boolean isLand() {
        return true;
    }

}
