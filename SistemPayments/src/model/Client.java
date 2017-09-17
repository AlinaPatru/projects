package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClient;

	private double deposit;

	private String name;

	private String password;

	private int state;

	private String username;

	//bi-directional many-to-one association to Relation
	@OneToMany(mappedBy="client")
	private List<Relation> relations;

	public Client() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public double getDeposit() {
		return this.deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
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

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Relation> getRelations() {
		return this.relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public Relation addRelation(Relation relation) {
		getRelations().add(relation);
		relation.setClient(this);

		return relation;
	}

	public Relation removeRelation(Relation relation) {
		getRelations().remove(relation);
		relation.setClient(null);

		return relation;
	}

	public Client(int idClient, double deposit, String name, String password, int state, String username,
			List<Relation> relations) {
		this.idClient = idClient;
		this.deposit = deposit;
		this.name = name;
		this.password = password;
		this.state = state;
		this.username = username;
		this.relations = relations;
	}

	public Client(String username2, String password1, String name2,int state) {
		this.username = username2;
		this.password = password1;
		this.name = name2;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", deposit=" + deposit + ", name=" + name + ", password=" + password
				+ ", state=" + state + ", username=" + username + ", relations=" + relations + "]";
	}
	
	
	
	
}