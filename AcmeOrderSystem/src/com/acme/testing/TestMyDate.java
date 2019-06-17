package com.acme.testing;
import com.acme.utils.MyDate;

public class TestMyDate{

	public static void main(String[] args){
		MyDate date1 = new MyDate(11,11,1918);

		MyDate date2 = new MyDate();
		date2.setDay(11);
		date2.setMonth(11);
		date2.setYear(1918);

		MyDate date3 = new MyDate();
		date3.setDate(12,21,1968);

		String str1 = date1.toString();
		String str2 = date2.toString();
		String str3 = date3.toString();

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		MyDate date4 = new MyDate();
		String str4 = date4.toString();
		System.out.println("Str4 is : " + str4);
		
//		MyDate.leapYears();
		
		MyDate newYear = new MyDate(1, 1, 2019);
		MyDate fiscalStart = new MyDate(1, 1, 2009);
		
		if(newYear.equals(fiscalStart)) {
			System.out.println("These two dates are equal");
		} else {
			System.out.println("These two dates are not equal!");
		}
		
		
		
//		MyDate date5 = new MyDate(1,1, 2019);
//		String str5 = date5.toString();
//		System.out.println("String 5 is: " + str5);
		MyDate.listHolidays();
	}
}