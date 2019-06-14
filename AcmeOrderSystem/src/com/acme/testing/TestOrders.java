package com.acme.testing;
import com.acme.domain.Good.UnitOfMeasureType;
import com.acme.domain.Order;
import com.acme.domain.Solid;
import com.acme.utils.MyDate;

public class TestOrders {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDate date1 = new MyDate(1,20,2008);
//		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", "Anvil", 10);
		Solid s1 = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", s1, 10);
		
		MyDate date2 = new MyDate(4,10,2008);
//		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", "Balloon", 125);
		Solid s2 = new Solid("Acme Balloon", 1401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);
		
		System.out.println(anvil);
		System.out.println(balloons);
		
		System.out.println("The tax rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();
		
		Order.setTaxRate(0.06);
		System.out.println("The tax rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();
		
		System.out.println("==============================");
		
		System.out.println("The total bill for " + anvil + " is " + anvil.computeTotal());
		System.out.println("The total bill for " + balloons + " is " + balloons.computeTotal());
		
		balloons.setQuantity(-200);
		
		System.out.println("==============================");
		System.out.println("The volume of the anvil is: " + anvil.getProduct().volume());
		//Fix this by using casting to cast the product reference back to its real Solid
		//type and then calling the getLength( ) method.
		System.out.println("The length of the anvil is: " + ( (Solid) anvil.getProduct()).getLength());
		
	}

}
