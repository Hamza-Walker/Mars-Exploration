package com.walker.mapElements.service.generator;

import com.walker.calculators.model.Coordinate;
import com.walker.configuration.model.MapConfiguration;
import com.walker.mapElements.model.Map;
import com.walker.mapElements.model.MapElement;
import com.walker.mapElements.service.placer.MapElementPlacer;

import java.util.List;

public class MapGeneratorImpl implements MapGenerator{

    private MapElementPlacer mapElementPlacer;
    private MapElementsGenerator mapElementsGenerator;

    public MapGeneratorImpl(MapElementsGenerator mapElementsGenerator, MapElementPlacer mapElementPlacer) {
        this.mapElementsGenerator = mapElementsGenerator;
        this.mapElementPlacer = mapElementPlacer;
    }

    @Override
    public Map generate(MapConfiguration mapConfig) {
        List<MapElement> mapElements = (List<MapElement>) mapElementsGenerator.createAll(mapConfig);
        int maxWidth = calculateMaxWidth(mapElements);
        int maxHeight = mapElements.size();

        String[][] mapArray = new String[maxHeight][maxWidth];

        for (MapElement mapElement : mapElements) {
            placeMapElementOnMap(mapElement, mapArray);
        }

        return new Map(mapArray);
    }


    private int calculateMaxWidth(List<MapElement> mapElements) {
        int maxWidth = 0;

        for (MapElement mapElement : mapElements) {
            int elementWidth = mapElement.getRepresentation()[0].length;
            if (elementWidth > maxWidth) {
                maxWidth = elementWidth;
            }
        }

        return maxWidth;
    }
    private void placeMapElementOnMap(MapElement mapElement, String[][] map) {
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
}
