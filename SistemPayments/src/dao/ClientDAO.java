package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;

public class ClientDAO 
{
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("System");
	private EntityManager em = emf.createEntityManager();
	
	public List<Client> getAllClients() 
	{
		return this.getEntityManager().createQuery("select s from model.Client s", Client.class).getResultList();
	}

	public Client getClientById(int id) 
	{
		Client clients = this.getEntityManager().find(Client.class, new Integer(id));
	    return clients;
	}
	
	public void addClient(Client c)
	{	 
		 em.getTransaction().begin();
		 em.persist(c);
		 em.getTransaction().commit();
	}
	
	public void updateClient(int id, String name, String password)
	{	 
		 Client c = em.find(Client.class, id);
		 
		 em.getTransaction().begin();
		 c.setName(name);
		 c.setPassword(password);
		 em.getTransaction().commit();
		 
	}
	
	public void updateDeposit(int id, double sum)
	{	 
		 Client c = em.find(Client.class, id);
		 double deposit =c.getDeposit() + sum;
		 em.getTransaction().begin();
		 c.setDeposit(deposit);
		 em.getTransaction().commit();
	}
	
	public void deleteFromDeposit(int id, double sum)
	{	 
		 Client c = em.find(Client.class, id);
		 double deposit =c.getDeposit() - sum;
		 em.getTransaction().begin();
		 c.setDeposit(deposit);
		 em.getTransaction().commit();
	}
	
	public void setNewDeposit(int id, double sum)
	{
		Client c = em.find(Client.class, id);
		em.getTransaction().begin();
		c.setDeposit(sum);
		em.getTransaction().commit();
	}
	
	public void deleteClient(int id)
	{	 
		 Client c = em.find(Client.class, id);
		 em.getTransaction().begin();
		 em.remove(c);
		 em.getTransaction().commit();
		 
	}
	private EntityManager getEntityManager() 
	{
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("System");
	    EntityManager em = emf.createEntityManager();
	    return em;
	}
		   
}
