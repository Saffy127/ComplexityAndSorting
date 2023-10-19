package main;
import shapes.*;
import utils.ShapeUtil;
import java.util.Comparator;
import comparators.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainApp {

    public static Shape[] readShapesFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int numShapes = Integer.parseInt(reader.readLine().trim());
        Shape[] shapes = new Shape[numShapes];
        
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String shapeType = parts[0];
            double height = Double.parseDouble(parts[1]);
            double secondParam = Double.parseDouble(parts[2]);
            
            switch (shapeType) {
                case "Cylinder":
                    shapes[i] = new Cylinder(height, secondParam);
                    break;
                case "Cone":
                    shapes[i] = new Cone(height, secondParam);
                    break;
                case "Pyramid":
                    shapes[i] = new Pyramid(height, secondParam);
                    break;
                case "SquarePrism":
                case "TriangularPrism":
                case "PentagonalPrism":
                case "OctagonalPrism":
                    shapes[i] = new Prism(height, secondParam);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid shape type in file");
            }
            i++;
        }
        
        reader.close();
        return shapes;
    }


    public static void main(String[] args) {
        try {
            // Parsing command-line arguments
            String filePath = "";
            String sortType = "";
            String algorithm = "";
            for (int i = 0; i < args.length; i++) {
                String arg = args[i];
                if (arg.equalsIgnoreCase("-f")) filePath = args[++i];
                if (arg.equalsIgnoreCase("-t")) sortType = args[++i];
                if (arg.equalsIgnoreCase("-s")) algorithm = args[++i];
            }
            
            // Reading shapes from the file
            Shape[] shapes = readShapesFromFile(filePath);

            // Getting the appropriate Comparator based on the sortType
            Comparator<Shape> comparator = null;
            if (sortType.equalsIgnoreCase("h")) {
                comparator = Shape::compareTo;
            } else if (sortType.equalsIgnoreCase("v")) {
                comparator = new ShapeComparator("volume");
            } else if (sortType.equalsIgnoreCase("a")) {
                comparator = new ShapeComparator("baseArea");
            }

            // Sorting the shapes using the selected algorithm
            long startTime = System.currentTimeMillis();
            switch (algorithm.toLowerCase()) {
                case "b":
                    ShapeUtil.bubbleSort(shapes, comparator);
                    break;
                case "s":
                    ShapeUtil.selectionSort(shapes, comparator);
                    break;
                case "i":
                    ShapeUtil.insertionSort(shapes, comparator);
                    break;
                case "m":
                    ShapeUtil.mergeSort(shapes, comparator);
                    break;
                case "q":
                    ShapeUtil.quickSort(shapes, comparator);
                    break;
            }
            long endTime = System.currentTimeMillis();
            
            // Print results
            System.out.println("Time taken: " + (endTime - startTime) + "ms");
            // Additional logic to print first, last and every 1000th element...
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
