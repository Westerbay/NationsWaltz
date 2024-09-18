package nationswaltz.nation;

import java.util.HashSet;

public class Nation extends HashSet<Territory> {

    private Capital _capital;
    private int _money;

    public Nation(Capital capital, int money) {
        _capital = capital;
        _money = money;
    }

    public Nation() {
        this(null, 0);
    }

    public Capital getCapital() {
        return _capital;
    }

    public void setCapital(Capital capital) {
        _capital = capital;
    }

    public int getMoney() {
        return _money;
    }

    public void setMoney(int money) {
        _money = money;
    }

    public int getIncome() {
        int total = 0;
        for (Territory territory : this) {
            total += territory.getIncome();
        }
        return total;
    }

    public void endTurn() {
        _money += getIncome();
    }

}
