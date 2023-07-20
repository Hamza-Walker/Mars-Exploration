package configuration;

import com.walker.configuration.model.MapElementConfig;
import com.walker.configuration.model.ElementToSize;
import com.walker.configuration.model.MapConfiguration;
import com.walker.configuration.service.MapConfigurationValidator;
import com.walker.configuration.service.MapConfigurationValidatorImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MapConfigurationValidatorTest {

    @Test
    public void testValidMapConfiguration() {
        List<MapElementConfig> mapElementConfigs = new ArrayList<>();
        mapElementConfigs.add(new MapElementConfig('#', true, List.of(new ElementToSize(3, 10)), 3, 4));
        mapElementConfigs.add(new MapElementConfig('&', true, List.of(new ElementToSize(10, 40)), 0, 5));
        mapElementConfigs.add(new MapElementConfig('%', false, List.of(new ElementToSize(0, 30)), 0, 7));
        mapElementConfigs.add(new MapElementConfig('*', false, List.of(new ElementToSize(0, 10)), 0, 6));

        double elementToSpaceRatio = 0.5;

        MapConfiguration mapConfiguration = new MapConfiguration(mapElementConfigs, elementToSpaceRatio);
        MapConfigurationValidator mapConfigurationValidator = new MapConfigurationValidatorImpl();

        boolean isValid = mapConfigurationValidator.validate(mapConfiguration);

        Assert.assertTrue("Expected MapConfiguration to be valid", isValid);
    }

    @Test
    public void testInvalidMapConfiguration() {
        List<MapElementConfig> mapElementConfigs = new ArrayList<>();
        mapElementConfigs.add(new MapElementConfig('#', true, List.of(new ElementToSize(3, 0)), 3, null));
        mapElementConfigs.add(new MapElementConfig('&', true, List.of(new ElementToSize(10, 0)), 0, null));
        mapElementConfigs.add(new MapElementConfig('%', true, List.of(new ElementToSize(0, 0)), 0, null)); // Violates the rule: minerals defined as multi-dimensional
        mapElementConfigs.add(new MapElementConfig('*', false, List.of(new ElementToSize(0, 0)), 0, null));

        double elementToSpaceRatio = 0.5;

        MapConfiguration mapConfiguration = new MapConfiguration(mapElementConfigs, elementToSpaceRatio);
        MapConfigurationValidator mapConfigurationValidator = new MapConfigurationValidatorImpl();

        boolean isValid = mapConfigurationValidator.validate(mapConfiguration);

        Assert.assertFalse("Expected MapConfiguration to be invalid", isValid);
    }

    @Test
    public void testValidMapConfigurationWithZeroElements() {
        List<MapElementConfig> mapElementConfigs = new ArrayList<>();
        double elementToSpaceRatio = 0.5;

        MapConfiguration mapConfiguration = new MapConfiguration(mapElementConfigs, elementToSpaceRatio);
        MapConfigurationValidator mapConfigurationValidator = new MapConfigurationValidatorImpl();

        boolean isValid = mapConfigurationValidator.validate(mapConfiguration);

        Assert.assertTrue("Expected MapConfiguration with no elements to be valid", !isValid);
    }

    @Test
    public void testInvalidMapConfigurationExceedingElementToSpaceRatio() {
        List<MapElementConfig> mapElementConfigs = new ArrayList<>();
        mapElementConfigs.add(new MapElementConfig('#', true, List.of(new ElementToSize(3, 0)), 3, null));
        mapElementConfigs.add(new MapElementConfig('&', true, List.of(new ElementToSize(10, 0)), 0, null));
        mapElementConfigs.add(new MapElementConfig('%', false, List.of(new ElementToSize(0, 0)), 0, null));
        mapElementConfigs.add(new MapElementConfig('*', false, List.of(new ElementToSize(0, 0)), 0, null));

        double elementToSpaceRatio = 0.1; // Violates the rule: total elements exceed the elementToSpaceRatio

        MapConfiguration mapConfiguration = new MapConfiguration(mapElementConfigs, elementToSpaceRatio);
        MapConfigurationValidator mapConfigurationValidator = new MapConfigurationValidatorImpl();

        boolean isValid = mapConfigurationValidator.validate(mapConfiguration);

        Assert.assertFalse("Expected MapConfiguration to be invalid", !isValid);
    }
}
