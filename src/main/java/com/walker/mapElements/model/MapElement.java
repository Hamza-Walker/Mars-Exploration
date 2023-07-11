package com.walker.mapElements.model;


import com.walker.configuration.model.PreferredLocationSymbol;

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
        return super.toString();
    }
}
