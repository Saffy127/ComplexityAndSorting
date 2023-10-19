package comparators;
import java.util.Comparator;
import shapes.Shape;

public class ShapeComparator implements Comparator<Shape> {
    private String sortingParameter;

    public ShapeComparator(String sortingParameter) {
        this.sortingParameter = sortingParameter;
    }

    @Override
    public int compare(Shape shape1, Shape shape2) {
        switch (sortingParameter) {
            case "height":
                return Double.compare(shape1.getHeight(), shape2.getHeight());
            case "baseArea":
                return Double.compare(shape1.getBaseArea(), shape2.getBaseArea());
            case "volume":
                return Double.compare(shape1.getVolume(), shape2.getVolume());
            default:
                throw new IllegalArgumentException("Invalid sorting parameter");
        }
    }
}
