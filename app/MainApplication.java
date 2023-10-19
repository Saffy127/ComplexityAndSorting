
package app;

import models.*;
import utils.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        if (args.length < 6) {
            displayError();
            return;
        }

        String fileName = null;
        ShapeComparator.CompareType compareType = null;
        String sortType = null;

        for (int i = 0; i < args.length; i += 2) {
            String key = args[i].toLowerCase();
            String value = args[i + 1].toLowerCase();

            switch (key) {
                case "-f":
                    fileName = value;
                    break;
                case "-t":
                    switch (value) {
                        case "v":
                            compareType = ShapeComparator.CompareType.VOLUME;
                            break;
                        case "h":
                            compareType = ShapeComparator.CompareType.HEIGHT;
                            break;
                        case "a":
                            compareType = ShapeComparator.CompareType.BASE_AREA;
                            break;
                        default:
                            displayError();
                            return;
                    }
                    break;
                case "-s":
                    sortType = value;
                    break;
                default:
                    displayError();
                    return;
            }
        }

        if (fileName == null || compareType == null || sortType == null) {
            displayError();
            return;
        }

        Shape[] shapes = readShapesFromFile(fileName);
        if (shapes == null) {
            System.out.println("Error reading shapes from file.");
            return;
        }

        long startTime = System.currentTimeMillis();

        switch (sortType) {
             case "b":
                SortingUtility.bubbleSort(shapes);
                break;
            case "s":
                SortingUtility.selectionSort(shapes);
                break;
            case "i":
                SortingUtility.insertionSort(shapes);
                break;
            case "m":
                SortingUtility.mergeSort(shapes, 0, shapes.length - 1);
                break;
            case "q":
                SortingUtility.quickSort(shapes, 0, shapes.length - 1);
                break;
            case "z":
                SortingUtility.heapSort(shapes);
                break;
            default:
                displayError();
                return;
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Time taken for sorting: " + (endTime - startTime) + " milliseconds");
        System.out.println("First shape: " + shapes[0]);
        System.out.println("Last shape: " + shapes[shapes.length - 1]);
        for (int i = 1000; i < shapes.length; i += 1000) {
            System.out.println("Shape at position " + i + ": " + shapes[i]);
        }
    }

    private static Shape[] readShapesFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Skip the header line
            String header = reader.readLine();
            if (header == null) {
                System.out.println("The file appears to be empty.");
                return null;
            }

            String shapeCountStr = reader.readLine();
            if (shapeCountStr == null) {
                System.out.println("Expected a line indicating the number of shapes.");
                return null;
            }

            int numberOfShapes = Integer.parseInt(shapeCountStr.trim());
            Shape[] shapes = new Shape[numberOfShapes];

            String line;
            for (int i = 0; i < numberOfShapes; i++) {
                line = reader.readLine();
                if (line == null) {
                    System.out.println("Expected more shapes in the file.");
                    return null;
                }

                String[] parts = line.split(" ");
                if (parts.length < 3) {
                    System.out.println("Incomplete data for shape on line " + (i + 2) + ". Skipping.");
                    continue;
                }

                String shapeType = parts[0];
                double height = Double.parseDouble(parts[1]);
                double dimension = Double.parseDouble(parts[2]);
               	 switch (shapeType) {
                case "Cylinder":
                    shapes[i] = new Cylinder(height, dimension);
                    break;
                case "Cone":
                    shapes[i] = new Cone(height, dimension);
                    break;
                case "Pyramid":
                    shapes[i] = new Pyramid(height, dimension);
                    break;
                case "SquarePrism":
                    shapes[i] = new SquarePrism(height, dimension);
                    break;
                case "TriangularPrism":
                    shapes[i] = new TriangularPrism(height, dimension);
                    break;
                case "PentagonalPrism":
                    shapes[i] = new PentagonalPrism(height, dimension);
                    break;
                case "OctagonalPrism":
                    shapes[i] = new OctagonalPrism(height, dimension);
                    break;
                default:
                    System.out.println("Unknown shape type: " + shapeType);
                    break;
            }
            }

            return shapes;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing shape data. Ensure the first line is a number and subsequent lines have valid shape data.");
            return null;
        }
    }

    private static void displayError() {
        System.out.println("Invalid arguments provided. Please use the following format:");
        System.out.println("java -jar sort.jar -f <file_name> -t <v/h/a> -s <b/s/i/m/q/z>");
    }
}



