package com.walker.configuration.model;

public enum PreferredLocationSymbol {
    PIT,
    MOUNTAIN,
    NONE;

    // Additional properties or methods can be added as needed

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
