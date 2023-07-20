package com.walker.mapElements.service.placer;

import com.walker.calculators.model.Coordinate;
import com.walker.mapElements.model.MapElement;

import java.util.Arrays;

public class MapElementPlacerImpl implements MapElementPlacer {
    @Override
    public boolean canPlaceElement(MapElement mapElement, String[][] map, Coordinate coordinate) {
        int x = coordinate.x();
        int y = coordinate.y();
        String[][] elementShape = mapElement.getRepresentation();

        for (int i = 0; i < elementShape.length; i++) {
            for (int j = 0; j < elementShape[i].length; j++) {
                if (elementShape[i][j] != null && (
                        y + i >= map.length ||
                                x + j >= map[0].length ||
                                (map[y + i][x + j] != null && !map[y + i][x + j].equals(" ")))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void placeElement(MapElement element, String[][] map, Coordinate coordinate) {
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

        String symbol = element.getSymbol();
        if (symbol.equals("#")) {
            spreadMountains(map, y, x, elementShape);
        } else if (symbol.equals("%")) {
            placeMineral(map, y, x);
        } else if (symbol.equals("*")) {
            placeWater(map, y, x);
        }
    }

    private void spreadMountains(String[][] map, int startY, int startX, String[][] elementShape) {
        int elementWidth = elementShape[0].length;
        int elementHeight = elementShape.length;

        for (int i = 0; i < elementHeight; i++) {
            for (int j = 0; j < elementWidth; j++) {
                if (map[startY + i][startX + j] == null) {
                    map[startY + i][startX + j] = "#";
                }
            }
        }
    }

    private void placeMineral(String[][] map, int y, int x) {
        if (x - 1 >= 0 && map[y][x - 1] == null) {
            map[y][x - 1] = "%";
        }
    }

    private void placeWater(String[][] map, int y, int x) {
        if (y - 1 >= 0 && map[y - 1][x] == null) {
            map[y - 1][x] = "*";
        }
    }

}
