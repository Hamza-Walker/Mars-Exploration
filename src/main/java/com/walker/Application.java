package com.walker;

import com.walker.configuration.model.ElementConfig;
import com.walker.configuration.model.MapConfiguration;
import com.walker.configuration.service.MapConfigurationValidator;
import com.walker.configuration.service.MapConfigurationValidatorImpl;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<ElementConfig> elementConfigs = new ArrayList<>();
        elementConfigs.add(new ElementConfig('#', true, 3));
        elementConfigs.add(new ElementConfig('&', true, 10));
        elementConfigs.add(new ElementConfig('%', false, 0));
        elementConfigs.add(new ElementConfig('*', false, 0));

        double elementToSpaceRatio = 0.5;

        MapConfiguration mapConfiguration = new MapConfiguration(elementConfigs, elementToSpaceRatio);
        MapConfigurationValidator mapConfigurationValidator = new MapConfigurationValidatorImpl();
        boolean isValid = mapConfigurationValidator.validate(mapConfiguration);

        System.out.println("Is MapConfiguration valid? " + isValid);
    }
}