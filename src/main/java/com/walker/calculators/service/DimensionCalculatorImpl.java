package com.walker.calculators.service;
import java.lang.Math;

public class DimensionCalculatorImpl implements DimensionCalculator {
    @Override
    public int calculateDimension(int desiredSize, int dimensionGrowth) {
        return (int) (Math.ceil(Math.sqrt(desiredSize)) + dimensionGrowth);
    }

}
