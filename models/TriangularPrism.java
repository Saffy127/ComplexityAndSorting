package models;

public class TriangularPrism extends Prism {
	public TriangularPrism(double height, double sideLength) {
		super(height, sideLength);
	}
	
	public double getBaseArea() {
		return ((getSideLength() * getSideLength()) * Math.sqrt(3)) / 4;
	}
	
	@Override
	public double getVolume() {
		return getBaseArea() * getHeight();
	}
}