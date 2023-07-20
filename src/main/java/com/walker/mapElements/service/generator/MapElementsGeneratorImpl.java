package com.walker.mapElements.service.generator;

import com.walker.configuration.model.ElementToSize;
import com.walker.configuration.model.MapConfiguration;
import com.walker.configuration.model.MapElementConfig;
import com.walker.mapElements.model.MapElement;
import com.walker.mapElements.service.builder.MapElementBuilder;

import java.util.ArrayList;
import java.util.List;

public class MapElementsGeneratorImpl implements MapElementsGenerator {
    private MapElementBuilder mapElementBuilder;

    public MapElementsGeneratorImpl(MapElementBuilder mapElementBuilder) {
        this.mapElementBuilder = mapElementBuilder;
    }

    @Override
    public Iterable<MapElement> createAll(MapConfiguration mapConfig) {
        List<MapElement> mapElements = new ArrayList<>();

        List<MapElementConfig> mapElementConfigs = mapConfig.getElementConfigs();
        for (MapElementConfig mapElementConfig : mapElementConfigs) {
            char symbol = mapElementConfig.getElement();
            boolean isMultiDimensional = mapElementConfig.isMultiDimensional();
            int dimensionGrowth = mapElementConfig.getDimensionGrowth();
            List<ElementToSize> mapSize = mapElementConfig.getSizes();


            MapElement mapElement = mapElementBuilder.build(
                    mapSize,
                    String.valueOf(symbol),
                    String.valueOf(mapElementConfig.getElement()),
                    dimensionGrowth,
                    mapElementConfig.getPreferredLocationSymbol()
            );
            mapElements.add(mapElement);
            //System.out.println(mapElement.toString());

        }

        return mapElements;
    }

}
