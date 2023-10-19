package models;

public class Pyramid extends Shape {
	private double sideLength;
	
	public Pyramid(double height, double sideLength) {
		super(height);
		this.sideLength = sideLength;
	}
	
	public double getBaseArea() {
		return this.sideLength * this.sideLength;
	}
	
	public double getVolume() {
		return ((this.sideLength * this.sideLength) * getHeight()) / 3;
	}
	
	public double getSideLength() {
		return sideLength;
	}

	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}
}