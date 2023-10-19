package shapes;

public class Pyramid extends Shape {
    private double baseLength;
    private double baseWidth;

    public Pyramid(double height, double baseLength) {
        super(height);  // Explicitly calling Shape's constructor
        this.baseLength = baseLength;
        this.baseWidth = baseWidth;
    }

  
	@Override
    public double getBaseArea() {
        return baseLength * baseWidth;
    }

    @Override
    public double getVolume() {
        return (1.0 / 3) * baseLength * baseWidth * height;
    }
}