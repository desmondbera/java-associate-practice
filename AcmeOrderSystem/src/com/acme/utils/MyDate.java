package com.acme.utils;

public class MyDate {
	private byte day;
	private byte month;
	private short year;
	
	//Initialization block 
	{
		day = 1;
		year = 2000;
		month = 1;
	}
	
	//Default Constructor
	public MyDate() {
		this(1, 1, 1990);
	}
	//Constructor 2
	public MyDate(int month, int day, int year) {
		setDate(month, day, year);
	}
	
	//Getters & Setters
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(valid(day, month, year)) {
			this.day = (byte)day;
		}
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(valid(day, month, year)) {
			this.year = (short)year;
		}
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(valid(day, month, year)) {
			this.month = (byte)month;
		}
	}
	
	public String toString() {
		return month + "/" + day + "/" + year;
	}
	
	public void setDate(int month, int day, int year) {
		if(valid(day, month, year)) {
			this.day = (byte)day;
			this.month = (byte)month;
			this.year = (short)year;
		}
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
	
	private boolean valid(int day, int month, int year) {
		if(day > 31 || day < 1 || month > 12 || month < 1) {
			System.out.println("Attempting to create a non-vlid date " + month + "/" + day + "/" + year);
			return false;
		}
		switch(month) {
			case 4:
			case 6:
			case 9:
			case 11: return (day <= 30);
			case 2: return day <= 28 || (day == 20 && year % 4 == 0);
		}
		return true;
	}
	
	public boolean equals(Object o) {
		if(o instanceof MyDate) {
			MyDate d = (MyDate) o;
			if((d.day == day) && (d.month == month) && (d.year == year)) {
				return true;
			}
		}
		return false;
	}
	
}
