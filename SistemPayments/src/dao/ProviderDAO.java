package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Provider;

public class ProviderDAO 
{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("System");
	private EntityManager em = emf.createEntityManager();
	
	public List<Provider> getAllProviders() 
	{
		return this.getEntityManager().createQuery("select p from model.Provider p", Provider.class).getResultList();
	}

	public Provider getProviderById(int id) 
	{
		Provider providers = this.getEntityManager().find(Provider.class, new Integer(id));
	    return providers;
	}
	
	public void addProvider(Provider p)
	{	 
		 em.getTransaction().begin();
		 em.persist(p);
		 em.getTransaction().commit();
	}
	
	public void updateProvider(int id, String name)
	{	 
		 Provider p = em.find(Provider.class, id);
		 
		 em.getTransaction().begin();
		 p.setName(name);
		 em.getTransaction().commit();
	}
	
	public void updateDeposit(int id, double sum)
	{	 
		 Provider p = em.find(Provider.class, id);
		 double deposit =p.getDeposit() + sum;
		 em.getTransaction().begin();
		 p.setDeposit(deposit);
		 em.getTransaction().commit();
	}
	
	public void deleteProvider(int id)
	{	 
		 Provider p = em.find(Provider.class, id);
		 em.getTransaction().begin();
		 em.remove(p);
		 em.getTransaction().commit();	 
	}
	
	private EntityManager getEntityManager() 
	{
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("System");
	    EntityManager em = emf.createEntityManager();
	    return em;
	}
	
}
