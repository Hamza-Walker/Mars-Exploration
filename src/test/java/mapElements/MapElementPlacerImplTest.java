package mapElements;

import com.walker.calculators.model.Coordinate;
import com.walker.configuration.model.PreferredLocationSymbol;
import com.walker.mapElements.model.MapElement;
import com.walker.mapElements.service.placer.MapElementPlacerImpl;
import org.junit.Test;
import static org.junit.Assert.*;

public class MapElementPlacerImplTest {
    @Test
    public void testCanPlaceElement() {
        String[][] representation = {{"X"}};
        String symbol = "#";
        String name = "Mountain";
        int dimension = 3;
        PreferredLocationSymbol preferredLocationSymbol = PreferredLocationSymbol.PIT;

        MapElementPlacerImpl placer = new MapElementPlacerImpl();
        String[][] map = new String[3][3];
        MapElement element = new MapElement(representation, symbol, name, dimension, preferredLocationSymbol);
        Coordinate coordinate = new Coordinate(0, 0);

        assertTrue(placer.canPlaceElement(element, map, coordinate));

        map[0][0] = "O";
        assertFalse(placer.canPlaceElement(element, map, coordinate));
    }

    @Test
    public void testPlaceElement() {
        String[][] representation = {{"X"}};
        String symbol = "#";
        String name = "Mountain";
        int dimension = 10;
        PreferredLocationSymbol preferredLocationSymbol = PreferredLocationSymbol.PIT;

        MapElementPlacerImpl placer = new MapElementPlacerImpl();
        String[][] map = new String[3][3];
        MapElement element = new MapElement(representation, symbol, name, dimension, preferredLocationSymbol);
        Coordinate coordinate = new Coordinate(0, 0);

        placer.placeElement(element, map, coordinate);
        assertEquals("X", map[0][0]);
    }
}
