package com.refactor.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	private Vector _rentals;

	public Customer(String _name) {
		this._name = _name;
		this._rentals = new Vector();
	}

	public String getName() {
		return _name;
	}

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\r\n");
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();

			double thisAmount = each.getCharge();
			frequentRenterPoints += each.getFrequentRenterPoints();

			result.append("\t").append(each.getMovie().getTitle()).append("\t").append(thisAmount).append("\r\n");

			totalAmount += thisAmount;
		}
		result.append("Amount owed is ").append(totalAmount).append("\r\n");
		result.append("You earned").append(frequentRenterPoints).append(" frequent renter points");
		return result.toString();
	}

	/**
	 * HTML格式的输出详单
	 * @param fileName
	 */
	public void htmlStatement(String fileName) {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		StringBuilder result = new StringBuilder("<html><h1>Rental Record for " + getName() + "</h1><br/>");
		result.append("<table border=1>");
		result.append("<tr><th>Movie</th><th>Charge</th></tr>");

		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();

			// determine amounts for each line
			double thisAmount = each.getCharge();

			// add frequent renter points
			frequentRenterPoints += each.getFrequentRenterPoints();

			// show figures for this rental
			result.append("<tr><td>").append(each.getMovie().getTitle()).append("</td><td>").append(thisAmount).append("</td></tr>");

			totalAmount += thisAmount;
		}

		result.append("</table>");
		// add footer lines
		result.append("<p>Amount owed is ").append(totalAmount).append("</p>");
		result.append("<p>You earned").append(frequentRenterPoints).append(" frequent renter points</p></html>");

		try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
			writer.write(result.toString());
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
