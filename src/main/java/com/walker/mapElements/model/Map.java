package com.walker.mapElements.model;

public class Map {
    private String[][] representation;

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

    private static String createStringRepresentation(String[][] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String[] row : arr){
            for (String element : row) {
                stringBuilder.append(element);
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return createStringRepresentation(representation);
    }
}

