package comparators;

import java.util.Comparator;
import shapes.Shape;

public class HeightComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return s1.compareTo(s2);
    }
}
