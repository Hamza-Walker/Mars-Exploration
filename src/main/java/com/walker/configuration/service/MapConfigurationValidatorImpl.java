package com.walker.configuration.service;

import com.walker.configuration.model.ElementConfig;
import com.walker.configuration.model.MapConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapConfigurationValidatorImpl implements MapConfigurationValidator {
    @Override
    public boolean validate(MapConfiguration mapConfiguration) {
        List<ElementConfig> elementConfigs = mapConfiguration.getElementConfigs();
        double elementToSpaceRatio = mapConfiguration.getElementToSpaceRatio();
        int totalElements = 0;
        boolean hasMinerals = false;

        Map<Character, Integer> elementCount = new HashMap<>();

        for (ElementConfig elementConfig : elementConfigs) {
            char element = elementConfig.getElement();
            elementCount.put(element, elementCount.getOrDefault(element, 0) + 1);

            if (element == '%') {
                if (elementConfig.isMultiDimensional()) {
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
