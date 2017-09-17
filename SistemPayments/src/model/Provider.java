package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the provider database table.
 * 
 */
@Entity
public class Provider implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProvider;

	private String name;

	private String password;

	private String service;

	private String username;
	
	private double deposit;
	
	private double price;

	//bi-directional many-to-one association to Relation
	@OneToMany(mappedBy="provider")
	private List<Relation> relations;

	public Provider() {
	}

	public int getIdProvider() {
		return this.idProvider;
	}

	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}
	
	public double getDeposit() {
		return this.deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Relation> getRelations() {
		return this.relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public Relation addRelation(Relation relation) {
		getRelations().add(relation);
		relation.setProvider(this);

		return relation;
	}

	public Relation removeRelation(Relation relation) {
		getRelations().remove(relation);
		relation.setProvider(null);

		return relation;
	}

	public Provider(int idProvider, String name, String password, String service, String username,double deposit, 
			double price , List<Relation> relations) 
	{
		this.idProvider = idProvider;
		this.name = name;
		this.password = password;
		this.service = service;
		this.username = username;
		this.relations = relations;
		this.deposit = deposit;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Provider [idProvider=" + idProvider + ", name=" + name + ", password=" + password + ", service="
				+ service + ", username=" + username + ", deposit=" + deposit + ", price =" + price +", relations=" + relations + "]";
	}


}