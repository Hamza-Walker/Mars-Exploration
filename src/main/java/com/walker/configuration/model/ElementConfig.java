package com.walker.configuration.model;

import com.walker.configuration.model.PreferredLocationSymbol;

public class ElementConfig {
    private char element;
    private boolean isMultiDimensional;
    private int dimensionGrowth;
    private PreferredLocationSymbol preferredLocationSymbol;
    private int mapSize;


    public ElementConfig(char element, boolean isMultiDimensional, int dimensionGrowth) {
        this.element = element;
        this.isMultiDimensional = isMultiDimensional;
        this.dimensionGrowth = dimensionGrowth;
        this.preferredLocationSymbol = determinePreferredLocationSymbol(element);
        this.mapSize = mapSize;
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

    public PreferredLocationSymbol getPreferredLocationSymbol() {
        return preferredLocationSymbol;
    }
    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    private PreferredLocationSymbol determinePreferredLocationSymbol(char element) {
        if (element == '*') {
            return PreferredLocationSymbol.PIT;
        } else if (element == '%') {
            return PreferredLocationSymbol.MOUNTAIN;
        } else {
            return PreferredLocationSymbol.NONE;
        }
    }
}
