package com.acme.domain;

public class Good {
	public enum UnitOfMeasureType { LITER, GALLON, CUBIC_METER, CUBIC_FEET };
	private String name;
	private int modelNumber;
	private double height;
	private UnitOfMeasureType unitOfMeasure;
	private boolean flammable = true;
	private double weightPerUofM;
	
	//Getters 
	public String getName() {
		return name;
	}
	public int getModelNumber() {
		return modelNumber;
	}
	public double getHeight() {
		return height;
	}
	public UnitOfMeasureType getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public boolean isFlammable() {
		return flammable;
	}
	public double getWeightPerUofM() {
		return weightPerUofM;
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setUnitOfMeasure(UnitOfMeasureType unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public void setFlammable(boolean flammable) {
		this.flammable = flammable;
	}
	public void setWeightPerUofM(double weightPerUofM) {
		this.weightPerUofM = weightPerUofM;
	}
	
	//Constructor
	public Good(String name, int modelNumber, double height, UnitOfMeasureType uoM, boolean flammable, double wgtPerUom) {
		this.name = name;
		this.modelNumber = modelNumber;
		this.height = height;
		this.unitOfMeasure = uoM;
		this.flammable = flammable;
		this.weightPerUofM = wgtPerUom;
	}
	
	public String toString() {
		return name + "-" + modelNumber;
	}
	
	public double volume() {
		return 0.0;
	}
	
	public double weight() {
		return volume() * weightPerUofM;
	}
}
