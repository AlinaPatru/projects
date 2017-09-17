package model;

import java.io.Serializable;

public class FinesTable implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int idRelation;
	private String providerName;
	private double fine;
	
	public FinesTable()
	{
		
	}
	
	public FinesTable(String providerName, double fine,int idRelation) {
		this.idRelation = idRelation;
		this.providerName = providerName;
		this.fine = fine;
	}
	
	public String getProviderName() {
		return providerName;
	}
	public double getFine() {
		return fine;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}

	public int getIdRelation() {
		return idRelation;
	}

	public void setIdRelation(int idRelation) {
		this.idRelation = idRelation;
	}
	

}
