package mapElements;

import com.walker.configuration.model.PreferredLocationSymbol;
import com.walker.mapElements.model.MapElement;
import com.walker.mapElements.service.builder.MapElementBuilder;
import com.walker.mapElements.service.builder.MapElementBuilderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapElementBuilderImplTest {

    @Test
    public void testBuild() {
        // Arrange
        int size = 5;
        String symbol = "#";
        String name = "mountain";
        int dimensionGrowth = 3;
        PreferredLocationSymbol preferredLocationSymbol = null;

        MapElementBuilder builder = new MapElementBuilderImpl();

        // Act
        MapElement mapElement = builder.build(size, symbol, name, dimensionGrowth, preferredLocationSymbol);

        // Assert
        Assertions.assertEquals(size, mapElement.getRepresentation().length);
        Assertions.assertEquals(size, mapElement.getRepresentation()[0].length);
        Assertions.assertEquals(symbol, mapElement.getSymbol());
        Assertions.assertEquals(name, mapElement.getName());
        Assertions.assertEquals(dimensionGrowth, mapElement.getDimension());
        Assertions.assertEquals(preferredLocationSymbol, mapElement.getPreferredLocationSymbol());
    }
}
