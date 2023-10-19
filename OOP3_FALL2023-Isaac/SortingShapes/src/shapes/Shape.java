package shapes; 
/**
 * Shape is an abstract class that represents a 3D shape.
 * It contains a height attribute and methods to get the base area and volume
 * of the shape. It also implements the Comparable interface to compare shapes
 * by their height.
 */
public abstract class Shape implements Comparable<Shape> {

    // The height of the shape
    protected double height;

    /**
     * Constructor for the Shape class.
     * @param height The height of the shape.
     */
    public Shape(double height) {
        this.height = height;
    }

    

	/**
     * Getter method for the height of the shape.
     * @return The height of the shape.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Abstract method to get the base area of the shape.
     * Must be implemented by all subclasses.
     * @return The base area of the shape.
     */
    public abstract double getBaseArea();

    /**
     * Abstract method to get the volume of the shape.
     * Must be implemented by all subclasses.
     * @return The volume of the shape.
     */
    public abstract double getVolume();

    /**
     * Implemented compareTo method from the Comparable interface.
     * Compares shapes by their height.
     * @param other The shape to compare with.
     * @return 1 if this shape's height is greater, -1 if smaller, 0 if equal.
     */
    @Override
    public int compareTo(Shape other) {
        if(this.height > other.height) return 1;
        if(this.height < other.height) return -1;
        return 0;
    }
}
