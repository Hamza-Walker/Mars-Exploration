package com.walker;

import com.walker.configuration.model.MapElementConfig;
import com.walker.configuration.model.ElementToSize;
import com.walker.configuration.model.MapConfiguration;
import com.walker.mapElements.model.Map;
import com.walker.mapElements.service.builder.MapElementBuilder;
import com.walker.mapElements.service.builder.MapElementBuilderImpl;
import com.walker.mapElements.service.generator.MapElementsGenerator;
import com.walker.mapElements.service.generator.MapElementsGeneratorImpl;
import com.walker.mapElements.service.generator.MapGenerator;
import com.walker.mapElements.service.generator.MapGeneratorImpl;
import com.walker.mapElements.service.placer.MapElementPlacer;
import com.walker.mapElements.service.placer.MapElementPlacerImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String OUTPUT_DIRECTORY = "maps/";

    public static void main(String[] args) {
        // Create a sample map configuration
        // when I change the element count nothing happens.
        // when I change the dimensional count nothing happens.
        // when I change the size the map is calculated by multiplying the value by its self
        List<MapElementConfig> mapElementConfigs = new ArrayList<>();
        mapElementConfigs.add(new MapElementConfig('#', true,
                List.of(new ElementToSize(20, 4)), 3, null));  // First Mountain
        mapElementConfigs.add(new MapElementConfig('&', true,
                List.of(new ElementToSize(10, 2)), 0, null)); // Pits
        mapElementConfigs.add(new MapElementConfig('%', false,
                List.of(new ElementToSize(0, 4)), 0, null)); // Minerals
        mapElementConfigs.add(new MapElementConfig('*', false,
                List.of(new ElementToSize(0, 5)), 0, null)); // Pockets of Water
        mapElementConfigs.add(new MapElementConfig('#', true,
                List.of(new ElementToSize(1, 5)), 4, null));  // Second Mountain


        double elementToSpaceRatio = 0.5;
        MapConfiguration mapConfig = new MapConfiguration(mapElementConfigs, elementToSpaceRatio);

        // Create the map element builder, map elements generator, and map element placer
        MapElementBuilder mapElementBuilder = new MapElementBuilderImpl();
        MapElementsGenerator mapElementsGenerator = new MapElementsGeneratorImpl(mapElementBuilder);
        MapElementPlacer mapElementPlacer = new MapElementPlacerImpl();

        // Create the map generator
        MapGenerator mapGenerator = new MapGeneratorImpl(mapElementsGenerator, mapElementPlacer);

        // Generate three sample maps
        for (int i = 1; i <= 3; i++) {
            Map map = mapGenerator.generate(mapConfig);
            writeMapToFile(map, "map" + i + ".txt");
        }
    }

    private static void writeMapToFile(Map map, String fileName) {
        try {
            File directory = new File(OUTPUT_DIRECTORY);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File outputFile = new File(directory, fileName);
            FileWriter fileWriter = new FileWriter(outputFile);
            fileWriter.write(map.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
