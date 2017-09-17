package model;

import java.io.Serializable;

public class ProviderTable implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String clientName;
    private double price;
    private String startDate;
    private String limitDate;
    private int idBill;
    
    public ProviderTable()
    {
    	
    }

	public ProviderTable(String clientName, double price, String startDate, String limitDate, int idBill) 
	{
		this.clientName = clientName;
		this.price = price;
		this.startDate = startDate;
		this.limitDate = limitDate;
		this.idBill = idBill;
	}

	public String getClientName() {
		return clientName;
	}

	public double getPrice() {
		return price;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getLimitDate() {
		return limitDate;
	}

	public int getIdBill() {
		return idBill;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	@Override
	public String toString() {
		return "ProviderTable [clientName=" + clientName + ", price=" + price + ", startDate=" + startDate
				+ ", limitDate=" + limitDate + ", idBill=" + idBill + "]";
	} 
    
	
	
}
