package nationswaltz.nation;

import java.util.HashSet;
import java.util.Random;
import java.awt.Color;

public class Nation extends HashSet<Territory> {

    private Capital _capital;
    private int _money;
    private Color _color;
	private final Random _random = new Random();
	
    public Nation(Capital capital, int money) {
        _capital = capital;
        _money = money;
        _color = generateColor();
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
    
    private Color generateColor() {
    	int red = _random.nextInt(255);
    	int green = _random.nextInt(255);
    	int blue = _random.nextInt(255);
    	return new Color(red, green, blue);
    }
    
    public Color getColor() {
    	return _color;
    }
    
    public void setColor(Color color) {
    	_color = color;
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
