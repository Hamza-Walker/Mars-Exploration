package com.walker.configuration.model;

import java.util.List;

public class MapConfiguration {
    private static List<ElementConfig> elementConfigs;
    private double elementToSpaceRatio;

    public MapConfiguration(List<ElementConfig> elementConfigs, double elementToSpaceRatio) {
        this.elementConfigs = elementConfigs;
        this.elementToSpaceRatio = elementToSpaceRatio;
    }

    public static List<ElementConfig> getElementConfigs() {
        return elementConfigs;
    }

    public double getElementToSpaceRatio() {
        return elementToSpaceRatio;
    }
}
