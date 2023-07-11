package com.walker.mapElements.service.generator;

import com.walker.configuration.model.MapConfiguration;
import com.walker.configuration.model.ElementConfig;
import com.walker.mapElements.model.MapElement;
import com.walker.mapElements.service.builder.MapElementBuilder;
import com.walker.mapElements.service.generator.MapElementsGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapElementsGeneratorImpl implements MapElementsGenerator {
    private MapElementBuilder mapElementBuilder;

    public MapElementsGeneratorImpl(MapElementBuilder mapElementBuilder) {
        this.mapElementBuilder = mapElementBuilder;
    }

    @Override
    public Iterable<MapElement> createAll(MapConfiguration mapConfig) {
        List<MapElement> mapElements = new ArrayList<>();

        List<ElementConfig> elementConfigs = mapConfig.getElementConfigs();
        for (ElementConfig elementConfig : elementConfigs) {
            char symbol = elementConfig.getElement();
            boolean isMultiDimensional = elementConfig.isMultiDimensional();
            int dimensionGrowth = elementConfig.getDimensionGrowth();
            Integer mapSize = elementConfig.getMapSize();

            // for testing purposes i will generate random mapSize
            if (mapSize == null) {
                mapSize = generateRandomSize();
            }

            MapElement mapElement = mapElementBuilder.build(
                    mapSize,
                    String.valueOf(symbol),
                    String.valueOf(elementConfig.getElement()),
                    dimensionGrowth,
                    elementConfig.getPreferredLocationSymbol()
            );
            mapElements.add(mapElement);
            System.out.println(mapElement.toString());

        }

        return mapElements;
    }

    private int generateRandomSize() {
        Random random = new Random();
        int minSize = 10; // Minimum size of the map
        int maxSize = 20; // Maximum size of the map
        return random.nextInt(maxSize - minSize + 1) + minSize;
    }
}
