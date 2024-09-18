package nationswaltz.map;

import nationswaltz.nation.Nation;
import nationswaltz.nation.Sea;
import nationswaltz.nation.Territory;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Map extends Voronoi {

    private final Nation _wilderness = new Nation();
    private final Random _random = new Random();
    private final List<Territory> _territories = new ArrayList<>();
    private final List<Territory> _lands = new ArrayList<>();
    private final List<Territory> _seas = new ArrayList<>();

    public Map(int nbCells, int width, int height) {
        super(nbCells, width, height);
        generateMap(_random.nextInt(2, 5), 0.05);
    }

    private void generateMap(int nbContinent, double probabilityIsle) {
        Rectangle[] continents = createContinents(nbContinent);
        for (Cell cell : getCells()) {
            Territory territory;
            if (cellsOnContinent(continents, cell) || _random.nextDouble() < probabilityIsle) {
                territory = new Territory(cell);
                territory.setNation(_wilderness);
                _lands.add(territory);
            }
            else {
                territory = new Sea(cell);
                _seas.add(territory);
            }
            _territories.add(territory);
        }
    }

    private boolean cellsOnContinent(Rectangle[] continents, Cell cell) {
        for (Rectangle continent : continents) {
            if (continent.contains(cell.getSite())) {
                return true;
            }
        }
        return false;
    }

    private Rectangle[] createContinents(int numberOfContinent) {
        Rectangle[] continents = new Rectangle[numberOfContinent];
        do {
            for (int i = 0; i < numberOfContinent; i++) {
                continents[i] = generateContinent(numberOfContinent);
            }
        } while(overlappingContinents(continents));
        return continents;
    }

    private Rectangle generateContinent(int numberOfContinent) {
        int width = _random.nextInt((int) (getWidth() / (1.5 * numberOfContinent)), getWidth() / numberOfContinent);
        int height = _random.nextInt((int) (getHeight() / (1.5 * numberOfContinent)), getHeight() / numberOfContinent);
        int x = _random.nextInt(getWidth() - width);
        int y = _random.nextInt(getHeight() - height);
        return new Rectangle(x, y, width, height);
    }

    private boolean overlappingContinents(Rectangle[] continents) {
        for (int i = 0; i < continents.length - 1; i++) {
            for (int j = i + 1; j < continents.length; j++) {
                if (continents[i].intersects(continents[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Territory> getTerritories() {
        return _territories;
    }

    public Nation getWilderness() {
        return _wilderness;
    }

}
