package models;


public class Cylinder extends Shape {
	private double radius;
	
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	
	public double getBaseArea() {
		return Math.PI * (this.radius * this.radius);
	}
	
	public double getVolume() {
		return getBaseArea() * getHeight();
	}
}