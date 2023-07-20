package mapElements;

import com.walker.configuration.model.MapElementConfig;
import com.walker.configuration.model.ElementToSize;
import com.walker.configuration.model.MapConfiguration;
import com.walker.mapElements.model.MapElement;
import com.walker.mapElements.service.builder.MapElementBuilder;
import com.walker.mapElements.service.generator.MapElementsGenerator;
import com.walker.mapElements.service.generator.MapElementsGeneratorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class MapElementsGeneratorImplTest {

    @Mock
    private MapElementBuilder mapElementBuilder;

    private MapElementsGenerator mapElementsGenerator;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mapElementsGenerator = new MapElementsGeneratorImpl(mapElementBuilder);
    }

    @Test
    public void testCreateAll() {
        // Prepare test data
        List<ElementToSize> sizes1 = List.of(new ElementToSize(1, 0));
        MapElementConfig mapElementConfig1 = new MapElementConfig('*', false, sizes1, 0, null);

        List<ElementToSize> sizes2 = List.of(new ElementToSize(2, 0), new ElementToSize(2, 0));
        MapElementConfig mapElementConfig2 = new MapElementConfig('#', true, sizes2, 1, null);

        List<MapElementConfig> mapElementConfigs = new ArrayList<>();
        mapElementConfigs.add(mapElementConfig1);
        mapElementConfigs.add(mapElementConfig2);

        // Mock the behavior of the MapElementBuilder
        MapElement mapElement1 = new MapElement(new String[][]{{"*"}}, "*", "Pit", 0, null);
        MapElement mapElement2 = new MapElement(new String[][]{{"#", "#"}, {"#", "#"}}, "#", "Mountain", 1, null);
        Mockito.when(mapElementBuilder.build(Mockito.anyList(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.any()))
                .thenReturn(mapElement1)
                .thenReturn(mapElement2);

        double elementToSpaceRatio = 0.5;
        MapConfiguration mapConfig = new MapConfiguration(mapElementConfigs, elementToSpaceRatio);

        // Invoke the method under test
        Iterable<MapElement> mapElements = mapElementsGenerator.createAll(mapConfig);

        // Assert the results
        List<MapElement> mapElementList = new ArrayList<>();
        mapElements.forEach(mapElementList::add);

        Assertions.assertEquals(2, mapElementList.size());
        Assertions.assertEquals(mapElement1, mapElementList.get(0));
        Assertions.assertEquals(mapElement2, mapElementList.get(1));
    }
}
