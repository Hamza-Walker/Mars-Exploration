package com.walker.mapElements.model;


import com.walker.configuration.model.PreferredLocationSymbol;

import java.util.Arrays;

public class MapElement extends Map {
    private String[][] representation;
    private String name;
    private int dimension;
    private PreferredLocationSymbol preferredLocationSymbol;
    private String symbol;

    public MapElement(String[][] representation, String symbol, String name, int dimension, PreferredLocationSymbol preferredLocationSymbol) {
        super(representation);
        this.representation = representation;
        this.symbol = symbol;
        this.name = name;
        this.dimension = dimension;
        this.preferredLocationSymbol = preferredLocationSymbol;
    }

    public String[][] getRepresentation() {
        return representation;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getDimension() {
        return dimension;
    }

    public PreferredLocationSymbol getPreferredLocationSymbol() {
        return preferredLocationSymbol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MapElement{");
        sb.append("representation=").append(Arrays.deepToString(representation));
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", dimension=").append(dimension);
        sb.append(", preferredLocationSymbol=").append(preferredLocationSymbol);
        sb.append('}');
        return sb.toString();
    }

}
