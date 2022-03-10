package controller;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {

	private int num;
	private Date date;
	private String cusName;
	private double invTotal;
	private ArrayList<InvoiceLine> lines;

	public InvoiceHeader(int num, Date date, String cusName) {
		this.num = num;
		this.date = date;
		this.cusName = cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusName() {
		return cusName;
	}


	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setInvTotal(double invTotal) {
		this.invTotal = invTotal;
	}

	public double getInvTotal() {
		return invTotal;
	}

	public ArrayList<InvoiceLine> getLines() {
		if(lines ==null)
			lines=new ArrayList<>();
		return lines;
	}

	public void setLines(ArrayList<InvoiceLine> lines) {
		this.lines = lines;
	}
	public void addLine(InvoiceLine Li){
		getLines().add(Li);
		setInvTotal(getInvTotal()+Li.getLineTotal());

	}


}