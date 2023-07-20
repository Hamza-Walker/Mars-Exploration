package com.walker.mapElements.service.builder;

import com.walker.configuration.model.ElementToSize;
import com.walker.configuration.model.PreferredLocationSymbol;
import com.walker.mapElements.model.MapElement;

import java.util.List;

public interface MapElementBuilder {
    MapElement build(List<ElementToSize> size, String symbol, String name, int dimensionGrowth, PreferredLocationSymbol preferredLocationSymbol);
}
