package com.walker.calculators.service;
import java.lang.Math;

public class DimensionCalculatorImpl implements DimensionCalculator {
    @Override
    public int calculateDimension(int desiredSize, int dimensionGrowth) {
        int dimension = (int) (Math.ceil(Math.sqrt(desiredSize)) + dimensionGrowth);
        return dimension;
    }

}
