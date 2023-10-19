package shapes;

public class Prism extends Shape {
    private double baseArea;

    public Prism(double height, double baseArea) {
        super(height);  // Explicitly calling Shape's constructor
        this.baseArea = baseArea;
    }

    @Override
    public double getBaseArea() {
        return baseArea;
    }

    @Override
    public double getVolume() {
        return baseArea * height;
    }
}