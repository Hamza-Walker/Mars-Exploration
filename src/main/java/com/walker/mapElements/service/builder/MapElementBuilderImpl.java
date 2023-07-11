package com.walker.mapElements.service.builder;

import com.walker.configuration.model.PreferredLocationSymbol;
import com.walker.mapElements.model.MapElement;

public class MapElementBuilderImpl implements MapElementBuilder {

    @Override
    public MapElement build(int size, String symbol, String name, int dimensionGrowth, PreferredLocationSymbol preferredLocationSymbol) {
        String[][] representation = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                representation[i][j] = " ";
            }
        }

        if (symbol.equals("#")) {
            // Mountains: Always multi-dimensional, random placement
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    representation[i][j] = "#";
                }
            }
        } else if (symbol.equals("&")) {
            // Pits: Multi-dimensional, random placement
            for (int i = 0; i < size / 2; i++) {
                for (int j = 0; j < size / 2; j++) {
                    representation[i][j] = "&";
                }
            }
        } else if (symbol.equals("%")) {
            // Minerals: Single-dimensional, placed next to mountains
            for (int i = 0; i < size / 2; i++) {
                representation[i][size / 2] = "%";
                representation[size / 2][i] = "%";
            }
        } else if (symbol.equals("*")) {
            // Pockets of Water: Single-dimensional, placed next to pits
            for (int i = 0; i < size / 2; i++) {
                representation[i][size / 2] = "*";
                representation[size / 2][i] = "*";
            }
        } else {
            // Unknown symbol, return null or handle the case accordingly
            return null;
        }

        return new MapElement(representation, symbol, name, dimensionGrowth, preferredLocationSymbol);
    }
}
