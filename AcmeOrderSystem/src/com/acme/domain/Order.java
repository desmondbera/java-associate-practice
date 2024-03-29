package com.acme.domain;
import com.acme.utils.MyDate;

public class Order {
	private MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private Product product;
	private int quantity;
	private static Rushable rushable;
	
	
	//Getters and Setters
	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) {
		if(isHoliday(orderDate)) {
			System.out.println("Order date, " + orderDate + ", cannot be set to a holiday!");
		} else {
			this.orderDate = orderDate;
		}
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		if(valid(orderAmount)) {
			this.orderAmount = orderAmount;
		}
	}
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Good product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(valid(quantity)) {
			this.quantity = quantity;
		}
	}

	public static Rushable getRushable() {
		return rushable;
	}
	
	public static void setRushable(Rushable rushable) {
		Order.rushable = rushable;
	}
	
	public static double taxRate;
	
	{
		taxRate = 0.05;
	}
	
	//Constructor
	public Order(MyDate d, double amt, String c, Product p, int q){
		setOrderDate(d);
		orderDate=d;
		orderAmount=amt;
		customer=c;
		product=p;
		quantity=q;
	}
	
	// Methods
	private boolean isHoliday(MyDate proposedDate) {
		boolean result = false;
		for(MyDate holiday : MyDate.getHolidays()) {
			if(holiday.equals(proposedDate)) {
				result = true;
			}
		}
		return result;
	}
	
	public boolean isPriorityOrder() {
		boolean priorityOrder = false;
		if(rushable != null) {
			priorityOrder = rushable.isRushable(orderDate, orderAmount);
		}
		return priorityOrder;
	}
	
	public String toString(){
		return quantity + " ea. " + product + " for " + customer; 
	}
	
	public static void setTaxRate(double newRate) {
		taxRate = newRate;
	}
	
	public static void computeTaxOn(double anAmount) {
		System.out.println("The tax for " + anAmount + " is: " + anAmount * Order.taxRate);
	}
	
	public double computeTax() {
//		System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
		return orderAmount * Order.taxRate;
	}
	
	public char jobSize() {
		if(quantity <= 25) {
			return 'S';
		} else if(quantity >= 26 && quantity <= 75) {
			return 'M';
		} else if(quantity >= 76 && quantity <= 150 ) {
			return 'L';
		}
		return 'X';
	}
	
	public double computeTotal() {
		
		double total = orderAmount;
		if(jobSize() == 'M') {
			total = total - (orderAmount * 0.01);
//			discPercent = 0.01;
		} else if(jobSize() == 'L') {
			total = total - (orderAmount * 0.02);
//			discPercent = 0.02;
		} else if(jobSize() == 'X') {
			total = total - (orderAmount * 0.02);
//			discPercent = 0.03;
		}
		if(orderAmount <= 1500) {
			total = total + computeTax();
		}
		
		return total;
	}
	
	private boolean valid(double num) {
		if((int)num < 0 ) {
			System.out.println("Attempting to create a non-valid amount.");
			return false;
		}
		return true;
	}
	
}
