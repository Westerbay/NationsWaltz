package nationswaltz.nation;

import nationswaltz.map.Cell;
import nationswaltz.map.Map;

public class Sea extends Territory {

    public Sea(Cell cell, Map map) {
        super(cell, map);
    }
    
    @Override
    public boolean isLand() {
        return false;
    }
}

