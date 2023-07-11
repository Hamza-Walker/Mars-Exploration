package com.walker.mapElements.service.placer;

import com.walker.calculators.model.Coordinate;
import com.walker.mapElements.model.MapElement;

public class MapElementPlacerImpl implements MapElementPlacer{
    @Override
    public boolean canPlaceElement(MapElement element, String[][] map, Coordinate coordinate) {
        // Check if the element can be placed at the given coordinate on the map
        int x = coordinate.x();
        int y = coordinate.y();

        String[][] elementShape = element.getRepresentation();
        for (int i = 0; i < elementShape.length; i++) {
            for (int j = 0; j < elementShape[i].length; j++) {
                if (elementShape[i][j] != null && (y + 1 >= map.length
                        || x + j >= map[0].length
                        || map[y + i][x + j] != null));
                return false;
            }
        }
        return true;
    }

    @Override
    public void placeElement(MapElement element, String[][] map, Coordinate coordinate) {
        // Place the element at the given coordinate on the map
        int x = coordinate.x();
        int y = coordinate.y();
        String[][] elementShape = element.getRepresentation();
        for (int i = 0; i < elementShape.length; i++) {
            for (int j = 0; j < elementShape[i].length; j++) {
                if (elementShape[i][j] != null) {
                    map[y + i][x + j] = elementShape[i][j];
                }
            }
        }
    }
}
