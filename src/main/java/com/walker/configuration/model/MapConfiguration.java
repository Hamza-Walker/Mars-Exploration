package com.walker.configuration.model;

import java.util.List;

public class MapConfiguration {
    private static List<MapElementConfig> mapElementConfigs;
    private double elementToSpaceRatio;

    public MapConfiguration(List<MapElementConfig> mapElementConfigs, double elementToSpaceRatio) {
        this.mapElementConfigs = mapElementConfigs;
        this.elementToSpaceRatio = elementToSpaceRatio;
    }

    public static List<MapElementConfig> getElementConfigs() {
        return mapElementConfigs;
    }

    public double getElementToSpaceRatio() {
        return elementToSpaceRatio;
    }
}
