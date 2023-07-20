package com.walker.configuration.service;

import com.walker.configuration.model.MapElementConfig;
import com.walker.configuration.model.MapConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapConfigurationValidatorImpl implements MapConfigurationValidator {
    @Override
    public boolean validate(MapConfiguration mapConfiguration) {
        List<MapElementConfig> mapElementConfigs = MapConfiguration.getElementConfigs();
        double elementToSpaceRatio = mapConfiguration.getElementToSpaceRatio();
        int totalElements = 0;
        boolean hasMinerals = false;

        Map<Character, Integer> elementCount = new HashMap<>();

        for (MapElementConfig mapElementConfig : mapElementConfigs) {
            char element = mapElementConfig.getElement();
            elementCount.put(element, elementCount.getOrDefault(element, 0) + 1);

            if (element == '%') {
                if (mapElementConfig.isMultiDimensional()) {
                    return false; // Violates the rule: minerals cannot be multidimensional
                }
                hasMinerals = true;
            }
        }

        if (!hasMinerals) {
            return false; // Violates the rule: minerals are not defined
        }

        for (int count : elementCount.values()) {
            totalElements += count;
        }

        int maxElements = (int) (elementToSpaceRatio * 100);
        return totalElements <= maxElements;
    }
}
