package com.walker.calculators.service;

public class DimensionCalculatorImpl implements DimensionCalculator {
    @Override
    public int calculateDimension(int desiredSize, int dimensionGrowth) {
        int dimension = 1;

        System.out.println("Initial dimension: " + dimension);

        while (dimension * dimension <= desiredSize + dimensionGrowth) {
            dimension++;
            System.out.println("Current dimension: " + dimension);
            System.out.println("Current total elements: " + (dimension * dimension));
            System.out.println("Desired size + dimension growth: " + (desiredSize + dimensionGrowth));
        }

        System.out.println("Final dimension: " + dimension);
        return dimension;
    }

}
