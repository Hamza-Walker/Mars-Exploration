package com.walker.calculators.service;

import com.walker.calculators.model.Coordinate;

public class CoordinateCalculatorImpl implements CoordinateCalculator{
    @Override
    public Coordinate getRandomCoordinate(int dimension) {
        int randomX = (int) (Math.random() * dimension);
        int randomY = (int) (Math.random() * dimension);
        return new Coordinate(randomX,randomY);

    }

    @Override
    public Iterable<Coordinate> getAdjacentCoordinates(Coordinate coordinate, int dimension) {
        return null;
    }

    @Override
    public Iterable<Coordinate> getAdjacentCoordinates(Iterable<Coordinate> coordinates, int dimension) {
        return null;
    }
}
