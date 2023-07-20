package com.walker.mapElements.service.generator;

import com.walker.calculators.model.Coordinate;
import com.walker.configuration.model.MapConfiguration;
import com.walker.mapElements.model.Map;
import com.walker.mapElements.model.MapElement;
import com.walker.mapElements.service.placer.MapElementPlacer;

import java.util.List;

public class MapGeneratorImpl implements MapGenerator {
    private final MapElementPlacer mapElementPlacer;
    private final MapElementsGenerator mapElementsGenerator;

    public MapGeneratorImpl(MapElementsGenerator mapElementsGenerator, MapElementPlacer mapElementPlacer) {
        this.mapElementsGenerator = mapElementsGenerator;
        this.mapElementPlacer = mapElementPlacer;
    }

    @Override
    public Map generate(MapConfiguration mapConfig) {
        List<MapElement> mapElements = (List<MapElement>) mapElementsGenerator.createAll(mapConfig);
        int maxWidth = calculateMaxWidth(mapElements);
        int maxHeight = calculateMaxHeight(mapElements);

        String[][] mapArray = new String[maxHeight][maxWidth];

        mapElements.forEach(mapElement -> placeMapElement(mapElement, mapArray));

        return new Map(mapArray);
    }

    private void placeMapElement(MapElement mapElement, String[][] map) {
        int mapWidth = map[0].length;
        int mapHeight = map.length;

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                Coordinate coordinate = new Coordinate(x, y);

                if (mapElementPlacer.canPlaceElement(mapElement, map, coordinate)) {
                    mapElementPlacer.placeElement(mapElement, map, coordinate);
                    return;
                }
            }
        }
    }

    private int calculateMaxWidth(List<MapElement> mapElements) {
        return mapElements.stream()
                .mapToInt(mapElement -> mapElement.getRepresentation()[0].length)
                .max()
                .orElse(0);
    }

    private int calculateMaxHeight(List<MapElement> mapElements) {
        return mapElements.stream()
                .mapToInt(mapElement -> mapElement.getRepresentation().length)
                .max()
                .orElse(0);
    }

}
