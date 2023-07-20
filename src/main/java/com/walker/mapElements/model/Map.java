package com.walker.mapElements.model;

public class Map {
    private final String[][] representation;
    private boolean successfullyGenerated;

    public Map(String[][] representation) {
        this.representation = representation;
    }

    public boolean isSuccessfullyGenerated() {
        return successfullyGenerated;
    }

    public void setSuccessfullyGenerated(boolean successfullyGenerated) {
        this.successfullyGenerated = successfullyGenerated;
    }

    public int getHeight() {
        return representation.length;
    }

    public int getWidth() {
        return representation[0].length;
    }

    private static String createStringRepresentation(String[][] arr) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String[] row : arr) {
            for (String element : row) {
                stringBuilder.append(element);
            }
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String[] row : representation) {
            for (String element : row) {
                sb.append(element);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
