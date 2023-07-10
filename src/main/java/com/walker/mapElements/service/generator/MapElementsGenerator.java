package com.walker.mapElements.service.generator;

import com.walker.configuration.model.MapConfiguration;
import com.walker.mapElements.model.MapElement;

public interface MapElementsGenerator {
    Iterable<MapElement> createAll(MapConfiguration mapConfig);
}
