package mapElements;

import com.walker.configuration.model.ElementToSize;
import com.walker.configuration.model.PreferredLocationSymbol;
import com.walker.mapElements.model.MapElement;
import com.walker.mapElements.service.builder.MapElementBuilder;
import com.walker.mapElements.service.builder.MapElementBuilderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapElementBuilderImplTest {

    @Test
    public void testBuild() {
        // Arrange
        List<ElementToSize> sizes = List.of(new ElementToSize(5, 1));
        String symbol = "#";
        String name = "mountain";
        int dimensionGrowth = 3;
        PreferredLocationSymbol preferredLocationSymbol = null;

        MapElementBuilder builder = new MapElementBuilderImpl();

        // Act
        MapElement mapElement = builder.build(sizes, symbol, name, dimensionGrowth, preferredLocationSymbol);

        // Assert
        Assertions.assertEquals(sizes.get(0).size(), mapElement.getRepresentation().length);
        Assertions.assertEquals(sizes.get(0).size(), mapElement.getRepresentation()[0].length);
        Assertions.assertEquals(symbol, mapElement.getSymbol());
        Assertions.assertEquals(name, mapElement.getName());
        Assertions.assertEquals(dimensionGrowth, mapElement.getDimension());
        Assertions.assertEquals(preferredLocationSymbol, mapElement.getPreferredLocationSymbol());
    }
}
