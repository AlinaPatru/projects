package model;

import java.io.Serializable;


public class ClientTable implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String providerName;
    private String providerService;
    private double price;
    private String limitDate;
    private int idBill;
    
    public ClientTable()
    {
    	
    }

	public ClientTable(String providerName, String providerService, double price, String limitDate, int idBill) 
	{
		this.providerName = providerName;
		this.providerService = providerService;
		this.price = price;
		this.limitDate = limitDate;
		this.idBill = idBill;
	}

	public String getProviderName() {
		return providerName;
	}

	public String getProviderService() {
		return providerService;
	}

	public double getPrice() {
		return price;
	}

	public String getLimitDate() {
		return limitDate;
	}

	public int getIdBill() {
		return idBill;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public void setProviderService(String providerService) {
		this.providerService = providerService;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	@Override
	public String toString() {
		return "ClientTable [providerName=" + providerName + ", providerService=" + providerService + ", price=" + price
				+ ", limitDate=" + limitDate + ", idBill=" + idBill + "]";
	} 
    
    
}
