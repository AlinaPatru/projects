package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bill database table.
 * 
 */
@Entity
public class Bill implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBill;

	private String limitDate;
	
	private double price;
	
	private String startDate;

	//bi-directional many-to-one association to Relation
	@ManyToOne
	@JoinColumn(name="idRelation")
	private Relation relation;

	public Bill() {
	}

	public int getIdBill() {
		return this.idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public String getLimitDate() {
		return this.limitDate;
	}

	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Relation getRelation() {
		return this.relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public Bill(double price, String startDate,String limitDate)
	{
		this.price = price;
		this.startDate = startDate;
		this.limitDate = limitDate;
	}
	
	public Bill(Relation relation, double price, String startDate,String limitDate)
	{
		this.relation = relation;
		this.price = price;
		this.startDate = startDate;
		this.limitDate = limitDate;
	}

	@Override
	public String toString() {
		return "Bill [idBill=" + idBill + ", limitDate=" + limitDate + ", price=" + price + ", startDate=" + startDate
				+ ", relation=" + relation + "]";
	}
	
	

}