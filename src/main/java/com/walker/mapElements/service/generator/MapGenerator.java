package com.walker.mapElements.service.generator;

import com.walker.configuration.model.MapConfiguration;
import com.walker.mapElements.model.Map;

public interface MapGenerator {
    Map generate(MapConfiguration mapConfig);
}
