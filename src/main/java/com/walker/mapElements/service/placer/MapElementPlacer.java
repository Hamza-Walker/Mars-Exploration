package com.walker.mapElements.service.placer;

import com.walker.calculators.model.Coordinate;
import com.walker.mapElements.model.MapElement;

public interface MapElementPlacer {
    boolean canPlaceElement(MapElement element, String[][] map, Coordinate coordinate);
    void placeElement(MapElement element, String[][] map, Coordinate coordinate);
}
