package com.walker.configuration.model;

import java.util.List;

public class MapElementConfig {
    private final char element;
    private final boolean isMultiDimensional;
    private final int dimensionGrowth;
    private final PreferredLocationSymbol preferredLocationSymbol;
    private final List<ElementToSize> sizes;


    public MapElementConfig(char element, boolean isMultiDimensional, List<ElementToSize> sizes, int dimensionGrowth, Integer mapSize) {
        this.element = element;
        this.isMultiDimensional = isMultiDimensional;
        this.sizes = sizes;
        this.dimensionGrowth = dimensionGrowth;
        this.preferredLocationSymbol = determinePreferredLocationSymbol(element);
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

    public List<ElementToSize> getSizes() {
        return sizes;
    }

    public PreferredLocationSymbol getPreferredLocationSymbol() {
        return preferredLocationSymbol;
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
