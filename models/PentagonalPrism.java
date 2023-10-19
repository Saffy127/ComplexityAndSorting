package models;

public class PentagonalPrism extends Prism {
	private static final double ANGLE_RADIAN = Math.PI / 5;
	
	public PentagonalPrism(double height, double sideLength) {
		super(height, sideLength);
	}
	
	public double getBaseArea() {
		return (5 * (getSideLength() * getSideLength()) * Math.tan(PentagonalPrism.ANGLE_RADIAN)) / 4;
	}
	
	@Override
	public double getVolume() {
		return getBaseArea() * getHeight();
	}
}