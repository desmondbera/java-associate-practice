package com.acme.utils;

public class MyDate {
	public int day;
	public int year;
	public int month;
	
	//Initialization block 
	{
		day = 1;
		year = 2000;
		month = 1;
	}
	
	//Default Constructor
	public MyDate() {
	
	}
	//Constructor 2
	public MyDate(int month, int day, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String toString() {
		return month + "/" + day + "/" + year;
	}
	
	public void setDate(int month, int day, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public static void leapYears() {
		System.out.println("Leap year method...");
		int currentYr = 1752;
		while(currentYr <= 2020) {			
			if( currentYr % 100 != 0 || currentYr % 400 == 0) {
				System.out.println("The year " + currentYr + " is a leap year!");
			}
			currentYr+=4;
		}
		
	}
}
