package com.walker.mapElements.model;


public class MapElement extends Map {
    private String[][] representation;
    private String name;
    private int dimension;
    private String preferredLocationSymbol;
    private String symbol;

    public MapElement(String[][] representation, String symbol, String name, int dimension, String preferredLocationSymbol) {
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

    public String getPreferredLocationSymbol() {
        return preferredLocationSymbol;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
