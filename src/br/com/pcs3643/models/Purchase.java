package br.com.pcs3643.models;

public class Purchase {
	private int id_pedido;
	private String client;
	private String motherboard;
	private String cpu;
	private String memory;
	private String hd;
	private String computer;
	private int motherboard_qty;
	private int cpu_qty;	
	private int memory_qty;
	private int hd_qty;
	private int computer_qty;
	private String month;
	private double total;
	
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getMotherboard() {
		return motherboard;
	}
	public void setMotherboard(String motherboard) {
		this.motherboard = motherboard;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getHd() {
		return hd;
	}
	public void setHd(String hd) {
		this.hd = hd;
	}
	public String getComputer() {
		return computer;
	}
	public void setComputer(String computer) {
		this.computer = computer;
	}
	public int getMotherboard_qty() {
		return motherboard_qty;
	}
	public void setMotherboard_qty(int motherboard_qty) {
		this.motherboard_qty = motherboard_qty;
	}
	public int getCpu_qty() {
		return cpu_qty;
	}
	public void setCpu_qty(int cpu_qty) {
		this.cpu_qty = cpu_qty;
	}
	public int getMemory_qty() {
		return memory_qty;
	}
	public void setMemory_qty(int memory_qty) {
		this.memory_qty = memory_qty;
	}
	public int getHd_qty() {
		return hd_qty;
	}
	public void setHd_qty(int hd_qty) {
		this.hd_qty = hd_qty;
	}
	public int getComputer_qty() {
		return computer_qty;
	}
	public void setComputer_qty(int computer_qty) {
		this.computer_qty = computer_qty;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
} 
