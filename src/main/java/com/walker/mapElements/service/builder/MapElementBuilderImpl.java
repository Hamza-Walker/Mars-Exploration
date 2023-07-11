package com.walker.mapElements.service.builder;

import com.walker.configuration.model.PreferredLocationSymbol;
import com.walker.mapElements.model.MapElement;

public class MapElementBuilderImpl implements MapElementBuilder {

    @Override
    public MapElement build(int size, String symbol, String name, int dimensionGrowth, PreferredLocationSymbol preferredLocationSymbol) {
        String[][] representation = new String[size][size]; // Create a square representation based on the given size
        return new MapElement(representation, symbol, name, dimensionGrowth, preferredLocationSymbol);
    }


}
