package mapElements;

import com.walker.calculators.model.Coordinate;
import com.walker.configuration.model.PreferredLocationSymbol;
import com.walker.mapElements.model.MapElement;
import com.walker.mapElements.service.placer.MapElementPlacerImpl;
import org.junit.Test;
import static org.junit.Assert.*;

public class MapElementPlacerImplTest {
    @Test
    public void testCanPlaceElement_shouldReturnTrue_whenElementCanBePlaced() {
        // Arrange
        String[][] representation = {{"X"}};
        String symbol = "#";
        String name = "Mountain";
        int dimension = 3;
        PreferredLocationSymbol preferredLocationSymbol = PreferredLocationSymbol.PIT;
        MapElement element = new MapElement(representation, symbol, name, dimension, preferredLocationSymbol);
        String[][] map = new String[3][3];
        Coordinate coordinate = new Coordinate(0, 0);
        MapElementPlacerImpl placer = new MapElementPlacerImpl();

        // Act
        boolean canPlaceElement = placer.canPlaceElement(element, map, coordinate);

        // Assert
        assertTrue(canPlaceElement);
    }

    @Test
    public void testCanPlaceElement_shouldReturnFalse_whenElementCannotBePlaced() {
        // Arrange
        String[][] representation = {{"X"}};
        String symbol = "#";
        String name = "Mountain";
        int dimension = 3;
        PreferredLocationSymbol preferredLocationSymbol = PreferredLocationSymbol.PIT;
        MapElement element = new MapElement(representation, symbol, name, dimension, preferredLocationSymbol);
        String[][] map = new String[3][3];
        map[0][0] = "O";
        Coordinate coordinate = new Coordinate(0, 0);
        MapElementPlacerImpl placer = new MapElementPlacerImpl();

        // Act
        boolean canPlaceElement = placer.canPlaceElement(element, map, coordinate);

        // Assert
        assertFalse(canPlaceElement);
    }

    @Test
    public void testPlaceElement_shouldPlaceElementAtCorrectCoordinate() {
        // Arrange
        String[][] representation = {{"X"}};
        String symbol = "#";
        String name = "Mountain";
        int dimension = 10;
        PreferredLocationSymbol preferredLocationSymbol = PreferredLocationSymbol.PIT;
        MapElement element = new MapElement(representation, symbol, name, dimension, preferredLocationSymbol);
        String[][] map = new String[3][3];
        Coordinate coordinate = new Coordinate(0, 0);
        MapElementPlacerImpl placer = new MapElementPlacerImpl();

        // Act
        placer.placeElement(element, map, coordinate);

        // Assert
        assertEquals("X", map[0][0]);
    }
}
