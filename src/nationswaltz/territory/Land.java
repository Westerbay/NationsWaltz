package nationswaltz.territory;

import nationswaltz.map.Cell;
import nationswaltz.map.Map;

/**
 * @author Wester
 */
public class Land extends Territory {

    public Land(Cell cell, Map map) {
        super(cell, map);
    }
    
    @Override
    public boolean isLand() {
        return true;
    }
}

