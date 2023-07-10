package com.walker.calculators.service;

import com.walker.calculators.model.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class CoordinateCalculatorImpl implements CoordinateCalculator{
    @Override
    public Coordinate getRandomCoordinate(int dimension) {
        int randomX = (int) (Math.random() * dimension);
        int randomY = (int) (Math.random() * dimension);
        return new Coordinate(randomX,randomY);

    }

    @Override
    public Iterable<Coordinate> getAdjacentCoordinates(Coordinate coordinate, int dimension) {
        List<Coordinate> adjacentCoordinates = new ArrayList<>();

        int x = coordinate.x();
        int y = coordinate.y();

        // Check left neighbor
        if (x > 0) {
            adjacentCoordinates.add(new Coordinate(x - 1, y));
        }

        // Check right neighbor
        if (x < dimension - 1) {
            adjacentCoordinates.add(new Coordinate(x + 1, y));
        }

        // Check top neighbor
        if (y > 0) {
            adjacentCoordinates.add(new Coordinate(x, y - 1));
        }

        // Check bottom neighbor
        if (y < dimension - 1) {
            adjacentCoordinates.add(new Coordinate(x, y + 1));
        }

        // Check top-left neighbor
        if (x > 0 && y > 0) {
            adjacentCoordinates.add(new Coordinate(x - 1, y - 1));
        }

        // Check top-right neighbor
        if (x < dimension - 1 && y > 0) {
            adjacentCoordinates.add(new Coordinate(x + 1, y - 1));
        }

        // Check bottom-left neighbor
        if (x > 0 && y < dimension - 1) {
            adjacentCoordinates.add(new Coordinate(x - 1, y + 1));
        }

        // Check bottom-right neighbor
        if (x < dimension - 1 && y < dimension - 1) {
            adjacentCoordinates.add(new Coordinate(x + 1, y + 1));
        }

        return adjacentCoordinates;
    }



    @Override
    public Iterable<Coordinate> getAdjacentCoordinates(Iterable<Coordinate> coordinates, int dimension) {
        List<Coordinate> adjacentCoordinates = new ArrayList<>();

        for (Coordinate coordinate : coordinates) {
            for (Coordinate adjacentCoordinate : getAdjacentCoordinates(coordinate, dimension)) {
                adjacentCoordinates.add(adjacentCoordinate);
            }
        }
        //System.out.println(adjacentCoordinates);
        return adjacentCoordinates;
    }


}
