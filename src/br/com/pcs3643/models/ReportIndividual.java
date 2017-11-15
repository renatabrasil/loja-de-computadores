package br.com.pcs3643.models;
import java.util.HashMap;

public class ReportIndividual {
	private String name;
	private HashMap<String, Integer> products;
	private HashMap<String, Double> prices;
	private double total_amount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, Integer> getProducts() {
		return products;
	}
	public void setProducts(HashMap<String, Integer> products) {
		this.products = products;
	}
	public HashMap<String, Double> getPrices() {
		return prices;
	}
	public void setPrices(HashMap<String, Double> prices) {
		this.prices = prices;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	
	
}
