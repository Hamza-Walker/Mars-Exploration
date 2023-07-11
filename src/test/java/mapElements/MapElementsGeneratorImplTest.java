package mapElements;

import com.walker.configuration.model.ElementConfig;
import com.walker.configuration.model.MapConfiguration;
import com.walker.mapElements.model.MapElement;
import com.walker.mapElements.service.builder.MapElementBuilder;
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

    private MapElementsGeneratorImpl mapElementsGenerator;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mapElementsGenerator = new MapElementsGeneratorImpl(mapElementBuilder);
    }

    @Test
    public void testCreateAll() {
        // Prepare test data
        ElementConfig elementConfig1 = new ElementConfig('*', false, 0);
        ElementConfig elementConfig2 = new ElementConfig('#', true, 1);
        List<ElementConfig> elementConfigs = new ArrayList<>();
        elementConfigs.add(elementConfig1);
        elementConfigs.add(elementConfig2);

        MapConfiguration mapConfiguration = new MapConfiguration(elementConfigs, 20);

        // Mock the behavior of the MapElementBuilder
        MapElement mapElement1 = new MapElement(new String[][]{{"*"}}, "*", "Pit", 0, null);
        MapElement mapElement2 = new MapElement(new String[][]{{"#", "#"}, {"#", "#"}}, "#", "Mountain", 1, null);
        Mockito.when(mapElementBuilder.build(Mockito.anyInt(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.any()))
                .thenReturn(mapElement1)
                .thenReturn(mapElement2);

        // Invoke the method under test
        Iterable<MapElement> mapElements = mapElementsGenerator.createAll(mapConfiguration);

        // Assert the results
        List<MapElement> mapElementList = new ArrayList<>();
        mapElements.forEach(mapElementList::add);

        Assertions.assertEquals(2, mapElementList.size());
        Assertions.assertEquals(mapElement1, mapElementList.get(0));
        Assertions.assertEquals(mapElement2, mapElementList.get(1));
    }
}
