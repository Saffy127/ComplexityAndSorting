package models;

public class SquarePrism extends Prism {
	public SquarePrism(double height, double sideLength) {
		super(height, sideLength);
	}
	
	public double getBaseArea() {
		return getSideLength() * getSideLength();
	}
	
	@Override
	public double getVolume() {
		return getBaseArea() * getHeight();
	}
}