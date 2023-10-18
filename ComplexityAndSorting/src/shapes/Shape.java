package shapes;

public abstract class Shape implements Comparable<Shape> {
    protected double height;

    public double getHeight() {
        return height;
    }

    public abstract double getBaseArea();
    public abstract double getVolume();
  
    @Override
    public int compareTo(Shape otherShape) {
        return Double.compare(this.getHeight(), otherShape.getHeight());
    }
}
