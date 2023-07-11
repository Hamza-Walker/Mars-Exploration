package mapElements;

import com.walker.calculators.model.Coordinate;
import com.walker.configuration.model.ElementConfig;
import com.walker.configuration.model.MapConfiguration;
import com.walker.mapElements.model.Map;
import com.walker.mapElements.model.MapElement;
import com.walker.mapElements.service.generator.MapElementsGenerator;
import com.walker.mapElements.service.placer.MapElementPlacer;
import com.walker.mapElements.service.generator.MapGenerator;
import com.walker.mapElements.service.generator.MapGeneratorImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class testGenerate {

    @Test
    public void testGenerate() {
        // Create mock objects for the dependencies
        MapElementsGenerator mapElementsGenerator = mock(MapElementsGenerator.class);
        MapElementPlacer mapElementPlacer = mock(MapElementPlacer.class);

        // Create a sample map configuration
        List<ElementConfig> elementConfigs = new ArrayList<>();
        // Add element configs to the list

        double elementToSpaceRatio = 0.5;
        MapConfiguration mapConfig = new MapConfiguration(elementConfigs, elementToSpaceRatio);

        // Create a sample list of map elements
        List<MapElement> mapElements = new ArrayList<>();
        // Add map elements to the list

        // Configure the mock mapElementsGenerator to return the sample list of map elements
        when(mapElementsGenerator.createAll(mapConfig)).thenReturn(mapElements);

        // Create an instance of the MapGeneratorImpl class
        MapGenerator mapGenerator = new MapGeneratorImpl(mapElementsGenerator, mapElementPlacer);

        // Generate the map using the MapGeneratorImpl class
        Map map = mapGenerator.generate(mapConfig);

        // Perform assertions to verify the expected results
        assertEquals(mapElements.size(), map.getHeight());
        // Add more assertions based on the expected behavior of the generate method and the generated map
    }
}
