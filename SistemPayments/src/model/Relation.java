package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the relation database table.
 * 
 */
@Entity
public class Relation implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRelation;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="relation")
	private List<Bill> bills;

	//bi-directional many-to-one association to Provider
	@ManyToOne
	@JoinColumn(name="idProvider")
	private Provider provider;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	private double fine;

	public Relation() 
	{
		bills=new ArrayList<Bill>();
	}

	public int getIdRelation() {
		return this.idRelation;
	}

	public void setIdRelation(int idRelation) {
		this.idRelation = idRelation;
	}
	
	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setRelation(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setRelation(null);

		return bill;
	}

	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Relation(Provider provider, Client client) 
	{
		//this.idRelation = idRelation;
		this.bills = new ArrayList<Bill>();
		this.provider = provider;
		this.client = client;
		this.fine=0;
	}

	@Override
	public String toString() {
		return "Relation [idRelation=" + idRelation + ", bills=" + bills + ", provider=" + provider + ", client="
				+ client + ", fine=" + fine + "]";
	}
	

}