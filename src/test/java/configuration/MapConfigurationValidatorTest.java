package configuration;

import com.walker.configuration.model.ElementConfig;
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
        List<ElementConfig> elementConfigs = new ArrayList<>();
        elementConfigs.add(new ElementConfig('#', true, 3));
        elementConfigs.add(new ElementConfig('&', true, 10));
        elementConfigs.add(new ElementConfig('%', false, 0));
        elementConfigs.add(new ElementConfig('*', false, 0));

        double elementToSpaceRatio = 0.5;

        MapConfiguration mapConfiguration = new MapConfiguration(elementConfigs, elementToSpaceRatio);
        MapConfigurationValidator mapConfigurationValidator = new MapConfigurationValidatorImpl();

        boolean isValid = mapConfigurationValidator.validate(mapConfiguration);

        Assert.assertTrue("Expected MapConfiguration to be valid", isValid);
    }

    @Test
    public void testInvalidMapConfiguration() {
        List<ElementConfig> elementConfigs = new ArrayList<>();
        elementConfigs.add(new ElementConfig('#', true, 3));
        elementConfigs.add(new ElementConfig('&', true, 10));
        elementConfigs.add(new ElementConfig('%', true, 0)); // Violates the rule: minerals defined as multi-dimensional
        elementConfigs.add(new ElementConfig('*', false, 0));

        double elementToSpaceRatio = 0.5;

        MapConfiguration mapConfiguration = new MapConfiguration(elementConfigs, elementToSpaceRatio);
        MapConfigurationValidator mapConfigurationValidator = new MapConfigurationValidatorImpl();

        boolean isValid = mapConfigurationValidator.validate(mapConfiguration);

        Assert.assertFalse("Expected MapConfiguration to be invalid", isValid);
    }

    @Test
    public void testValidMapConfigurationWithZeroElements() {
        List<ElementConfig> elementConfigs = new ArrayList<>();
        double elementToSpaceRatio = 0.5;

        MapConfiguration mapConfiguration = new MapConfiguration(elementConfigs, elementToSpaceRatio);
        MapConfigurationValidator mapConfigurationValidator = new MapConfigurationValidatorImpl();

        boolean isValid = mapConfigurationValidator.validate(mapConfiguration);

        Assert.assertTrue("Expected MapConfiguration with no elements to be valid", !isValid);
    }

    @Test
    public void testInvalidMapConfigurationExceedingElementToSpaceRatio() {
        List<ElementConfig> elementConfigs = new ArrayList<>();
        elementConfigs.add(new ElementConfig('#', true, 3));
        elementConfigs.add(new ElementConfig('&', true, 10));
        elementConfigs.add(new ElementConfig('%', false, 0));
        elementConfigs.add(new ElementConfig('*', false, 0));

        double elementToSpaceRatio = 0.1; // Violates the rule: total elements exceed the elementToSpaceRatio

        MapConfiguration mapConfiguration = new MapConfiguration(elementConfigs, elementToSpaceRatio);
        MapConfigurationValidator mapConfigurationValidator = new MapConfigurationValidatorImpl();

        boolean isValid = mapConfigurationValidator.validate(mapConfiguration);

        Assert.assertFalse("Expected MapConfiguration to be invalid", !isValid);
    }
}
