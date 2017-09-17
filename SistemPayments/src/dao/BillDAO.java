package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Bill;

public class BillDAO 
{
	
	 private EntityManagerFactory emf = Persistence.createEntityManagerFactory("System");
	 private EntityManager em = emf.createEntityManager();
	
	public List<Bill> getAllBills() 
	{
		return this.getEntityManager().createQuery("select b from model.Bill b", Bill.class).getResultList();
	}

	public Bill getBillById(int id) 
	{
		Bill bill = this.getEntityManager().find(Bill.class, new Integer(id));
	    return bill;
	}
	
	public void addBill(Bill b)
	{	   
		 em.getTransaction().begin();
		 em.persist(b);
		 em.getTransaction().commit();
	}
	
	public void deleteBill(int id)
	{	  
		 Bill b = em.find(Bill.class, id);
		 em.getTransaction().begin();
		 if(b!=null)
			 em.remove(b);
		 em.getTransaction().commit();	 
	}
	
	
	private EntityManager getEntityManager() 
	{
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("System");
	    EntityManager em = emf.createEntityManager();
	    return em;
	}

}
