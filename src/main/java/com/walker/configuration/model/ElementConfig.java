package com.walker.configuration.model;

public class ElementConfig {

    private char element;
    private boolean isMultiDimensional;
    private int dimensionGrowth;

    public ElementConfig(char element, boolean isMultiDimensional, int dimensionGrowth) {
        this.element = element;
        this.isMultiDimensional = isMultiDimensional;
        this.dimensionGrowth = dimensionGrowth;
    }

    public char getElement() {
        return element;
    }

    public boolean isMultiDimensional() {
        return isMultiDimensional;
    }

    public int getDimensionGrowth() {
        return dimensionGrowth;
    }
}
