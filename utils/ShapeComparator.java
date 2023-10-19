package utils;


import models.Shape;
import java.util.Comparator;

/**
 * Comparator for comparing shapes based on different criteria.
 */
public class ShapeComparator implements Comparator<Shape> {

    public enum CompareType {
        HEIGHT, VOLUME, BASE_AREA
    }

    private CompareType compareType;

    /**
     * Constructor for ShapeComparator.
     * @param compareType the type of comparison (height, volume, or base area)
     */
    public ShapeComparator(CompareType compareType) {
        this.compareType = compareType;
    }

    @Override
    public int compare(Shape shape1, Shape shape2) {
        switch (compareType) {
            case HEIGHT:
                return Double.compare(shape1.getHeight(), shape2.getHeight());
            case VOLUME:
                return Double.compare(shape1.getVolume(), shape2.getVolume());
            case BASE_AREA:
                return Double.compare(shape1.getBaseArea(), shape2.getBaseArea());
            default:
                throw new IllegalArgumentException("Invalid Compare Type");
        }
    }
}
