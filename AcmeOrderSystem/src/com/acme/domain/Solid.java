package com.acme.domain;

public class Solid extends Good {
	private double width;
	private double length;
	
	//Getters 
	public double getWidth() {
		return width;
	}
	public double getLength() {
		return length;
	}
	
	//Setters
	public void setWidth(double width) {
		this.width = width;
	}
	public void setLength(double length) {
		this.length = length;
	}
	
	//Constructor
	public Solid(String name, int modelNumber, double height, UnitOfMeasureType uoM, boolean flammable, double wgtPerUofM, double width, double length) {
		super(name, modelNumber, height, uoM, flammable, wgtPerUofM);
		this.width = width;
		this.length = length;
	}
	
	public double volume() {
		return width * length * getHeight();
	}
	
	public String toString() {
		return super.toString() + " that is " + volume() + " " + getUnitOfMeasure() + " in size";
	}
	
}
