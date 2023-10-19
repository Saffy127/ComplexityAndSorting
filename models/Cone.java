package models;


public class Cone extends Shape {
	private double radius;
	
	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	
	public double getBaseArea() {
		return Math.PI * this.radius * this.radius;
	}
	
	@Override
	public double getVolume() {
		return (getBaseArea() * getHeight()) / 3;
	}
}