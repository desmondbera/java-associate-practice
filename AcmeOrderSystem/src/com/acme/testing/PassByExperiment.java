package com.acme.testing;

import com.acme.utils.MyDate;

public class PassByExperiment {

	public static void main(String[] args) {
		MyDate date = new MyDate(1, 20, 2008);
		System.out.println("Before passing an object -> " + date);
		passObject(date);
		System.out.println("After passing an object -> " + date);
		
		System.out.println("==================================");
		
		System.out.println("Before passing a primitive -> " + date.year);
		passPrimitive(date.year);
		System.out.println("After passing a primitive -> "+ date.year);
		
		System.out.println("==================================");
		
		String x = date.toString();
		System.out.println("Before passing a string -> " + x);
		passString(x);
		System.out.println("After passing a string -> " + x);
		
		
		System.out.println("==================================");
		
		StringBuilder y = new StringBuilder(date.toString());
		System.out.println("Before passing string builder -> " + y);
		passStringBuilder(y);
		System.out.println("After passing string builder -> " + y);
		
	}
	public static void passObject(MyDate d) {
		d.year = 2009;
	}
	
	public static void passPrimitive(int i) {
		i = 2010;
	}
	
	public static void passString(String s) {
		int yearSlash = s.lastIndexOf("/");
		s = s.substring(0, yearSlash+1);
		s += "2012";
		System.out.println("New date string is: " + s);
	}
	
	public static void passStringBuilder(StringBuilder s) {
		int yearSlash = s.lastIndexOf("/");
		StringBuilder newS = new StringBuilder(s);
		StringBuilder newS2 = newS.replace(yearSlash+1, newS.length(), "2012");
		System.out.println("New date string using string builder is: " + newS2);
	}
}
