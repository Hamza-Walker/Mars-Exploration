package calculator;

import com.walker.calculators.model.Coordinate;
import com.walker.calculators.service.CoordinateCalculator;
import com.walker.calculators.service.CoordinateCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CoordinateCalculatorImplTest {

    @Test
    public void testGetRandomCoordinate() {
        CoordinateCalculator coordinateCalculator = new CoordinateCalculatorImpl();

        int dimension = 5;

        // Generate multiple random coordinates and verify they fall within the dimension
        for (int i = 0; i < 100; i++) {
            Coordinate coordinate = coordinateCalculator.getRandomCoordinate(dimension);
            Assert.assertTrue(coordinate.x() >= 0 && coordinate.x() < dimension);
            Assert.assertTrue(coordinate.y() >= 0 && coordinate.y() < dimension);
        }
    }

    @Test
    public void testGetAdjacentCoordinates() {
        CoordinateCalculator coordinateCalculator = new CoordinateCalculatorImpl();

        int dimension = 5;
        Coordinate coordinate = new Coordinate(2, 2);

        // Get adjacent coordinates for the center coordinate (2, 2)
        Iterable<Coordinate> adjacentCoordinates = coordinateCalculator.getAdjacentCoordinates(coordinate, dimension);

        // Convert the iterable to a list for easier assertions
        List<Coordinate> adjacentCoordinateList = new ArrayList<>();
        adjacentCoordinates.forEach(adjacentCoordinateList::add);

        // Expected adjacent coordinates: (1, 2), (3, 2), (2, 1), (2, 3)
        List<Coordinate> expectedAdjacentCoordinates = Arrays.asList(
                new Coordinate(1, 2),
                new Coordinate(3, 2),
                new Coordinate(2, 1),
                new Coordinate(2, 3)
        );

        Assert.assertEquals(expectedAdjacentCoordinates, adjacentCoordinateList);
    }

    @Test
    public void testGetAdjacentCoordinates_MultipleCoordinates() {
        CoordinateCalculator coordinateCalculator = new CoordinateCalculatorImpl();

        int dimension = 5;
        Iterable<Coordinate> coordinates = Set.of(
                new Coordinate(1, 1),
                new Coordinate(3, 3),
                new Coordinate(2, 4)
        );

        // Get adjacent coordinates for the multiple input coordinates
        Iterable<Coordinate> adjacentCoordinates = coordinateCalculator.getAdjacentCoordinates(coordinates, dimension);

        // Convert the iterables to sets for unordered comparison
        Set<Coordinate> expectedAdjacentCoordinates = new HashSet<>();
        Set<Coordinate> actualAdjacentCoordinates = new HashSet<>();

        coordinates.forEach(coordinate -> expectedAdjacentCoordinates.addAll((Collection<? extends Coordinate>) coordinateCalculator.getAdjacentCoordinates(coordinate, dimension)));
        adjacentCoordinates.forEach(actualAdjacentCoordinates::add);

        Assert.assertEquals(expectedAdjacentCoordinates, actualAdjacentCoordinates);
    }

}
