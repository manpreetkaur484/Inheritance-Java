package Assignment5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerDatabase {

	public static void main(String[] args) {

		int size = 10;
		Service[] ser = new Service[size];
		Purchaser[] p = new Purchaser[size];

		Service sr = new Service("Manpreet", "4", 4);
		Purchaser pu = new Purchaser("Manpreet", 5);

		ArrayList<Double> myArrayList = new ArrayList<Double>();
		String choice = "";
		double total = 0;
		int cnt = 0;
		int cnt2 = 0;
		Scanner s = new Scanner(System.in);
		while (true) {

			System.out.println("Do you want to create customer? (y/n)");
			choice = s.nextLine();

			if (choice.equalsIgnoreCase("y")) {

				System.out.println("Do you want to add 'Purchaser' customer or 'Service' customer? (P/S): ");
				choice = s.nextLine();

				switch (choice.toLowerCase()) {
				case "p":

					p[cnt++] = new Purchaser(Helper.getString("Please enter your name: "),
							pu.getData("Please enter your monthly Payments: "));

					break;

				case "s":
					ser[cnt2++] = new Service(Helper.getString("Please enter your name: "),
							sr.getData2("Enter the ServiceDate: "), sr.getData("Enter the invoiceAmount: "));
					break;
				}// switch

			} // if

			else {
				System.out.println("thank you, you chose to exit.");
				break;
			}
		} // while

		// ARRAY LIST

		// purchaser class returning monthly payments

		for (int i = 0; i < cnt; i++) {
			myArrayList.add(p[i].showData());
		}
		System.out.println("ArrayList printed using Iteratory Class");

		Iterator iter = myArrayList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		// service class returning service date
		ArrayList<Double> myArrayList2 = new ArrayList<Double>();
		myArrayList2.add(sr.showData());

		// service class returning invoice amount
		ArrayList<Double> myArrayList3 = new ArrayList<Double>();
		myArrayList3.add(sr.showData());

		for (int i = 0; i < cnt; i++) {

			total += p[i].showData();
		}
		System.out.println("The total of all the monthly invoices is: " + total);
	}
}

interface Interface {
	public abstract double getData(String a);

	public abstract double showData();

	public abstract String getData2(String prompt);
}

abstract class Customer implements Interface {
	protected String customerName;

	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}

	public String toString() {
		return "Customer name is: " + customerName;
	}
}// customer class ending

class Purchaser extends Customer {
	private double monthlyPayment;

	public Purchaser(String customerName, double monthlyPayment) {
		super(customerName);
		this.monthlyPayment = monthlyPayment;
	}

	public double getData(String prompt) {
		Scanner s = new Scanner(System.in);
		System.out.println(prompt);
		return s.nextDouble();
	}

	public double showData() {
		return this.monthlyPayment;
	}

	public String getData2(String prompt) {
		return "";
	}

	public String toString() {
		return super.toString() + String.format("Purchaser's monthly Payment is: %2.2d", monthlyPayment);
	}
}// Purchaser class ending

class Service extends Customer {
	private String serviceDate;
	private double invoiceAmount;

	public Service(String customerName, String serviceDate, double invoiceAmount) {
		super(customerName);
		this.serviceDate = serviceDate;
		this.invoiceAmount = invoiceAmount;
	}

	public double getData(String prompt) {
		Scanner s = new Scanner(System.in);
		System.out.println(prompt);
		return s.nextDouble();
	}

	public String getData2(String prompt) {
		Scanner s = new Scanner(System.in);
		System.out.println(prompt);
		return s.nextLine();
	}

	public String showData1() {
		return serviceDate;
	}

	public double showData() {
		return invoiceAmount;
	}

	public String toString() {
		return super.toString() + String
				.format("The service date is: " + serviceDate + "and the Invoice Amount is: %2.2d", invoiceAmount);
	}

}// Service class ending

class Helper {

	public static String getString(String prompt) {
		Scanner s = new Scanner(System.in);
		System.out.print(prompt);
		return s.nextLine();
	}
}