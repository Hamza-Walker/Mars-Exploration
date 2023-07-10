package com.walker.calculators.service;

public class DimensionCalculatorImpl implements DimensionCalculator {
    @Override
    public int calculateDimension(int desiredSize, int dimensionGrowth) {
        int currentDimension = 1;
        int currentSize = 1;

        while (currentSize < desiredSize) {
            currentDimension += dimensionGrowth;
            currentSize = currentDimension * currentDimension;
        }

        return currentDimension;
    }
}

