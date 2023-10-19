package models;

public abstract class Prism extends Shape {
	private double sideLength;
	
	public Prism(double height, double sideLength) {
		super(height);
		this.sideLength = sideLength;
	}
	
	@Override
	public double getVolume() {
		return getBaseArea() * getHeight();
	}

	public double getSideLength() {
		return this.sideLength;
	}

	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}
}