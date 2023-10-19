package models;

public class OctagonalPrism extends Prism {
	public OctagonalPrism(double height, double sideLength) {
		super(height, sideLength);
	}
	
	public double getBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * (getSideLength() * getSideLength());
	}
	
	@Override
	public double getVolume() {
		return getBaseArea() * getHeight();
	}
}