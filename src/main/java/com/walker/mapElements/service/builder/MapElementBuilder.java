package com.walker.mapElements.service.builder;

import com.walker.configuration.model.PreferredLocationSymbol;
import com.walker.mapElements.model.MapElement;

public interface MapElementBuilder {
    MapElement build(int size, String symbol, String name, int dimensionGrowth, PreferredLocationSymbol preferredLocationSymbol);
}
