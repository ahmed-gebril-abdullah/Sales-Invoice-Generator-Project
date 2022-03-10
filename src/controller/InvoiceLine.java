package controller;

public class InvoiceLine {


	private double price;
	private int count;
	public InvoiceHeader invoice;
	private double lineTotal;
	private String product;


	public InvoiceLine(String product, double price, int count, InvoiceHeader invoice) {
		this.price = price;
		this.count = count;
		this.invoice = invoice;
		this.setLineTotal(this.count*this.price);
		this.product = product;

	}


	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setInvoice(InvoiceHeader invoice) {
		this.invoice = invoice;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public InvoiceHeader getInvoice() {
		return invoice;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}








}