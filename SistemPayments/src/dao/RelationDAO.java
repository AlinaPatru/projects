package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Bill;
import model.Relation;

public class RelationDAO 
{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("System");
	private EntityManager em = emf.createEntityManager();
	
	public List<Relation> getAllRelations() 
	{
		return this.getEntityManager().createQuery("select r from model.Relation r", Relation.class).getResultList();
	}

	public Relation getRelationById(int id) 
	{
		Relation relation = this.getEntityManager().find(Relation.class, new Integer(id));
	    return relation;
	}
	
	public void addRelation(Relation r)
	{	 
		 em.getTransaction().begin();
		 em.persist(r);
		 em.getTransaction().commit();
	}
	
	public void updateRelation(int id, List<Bill> bills)
	{	 
		 Relation r = em.find(Relation.class, id);
		 
		 em.getTransaction().begin();
		 r.setBills(bills);
		 em.getTransaction().commit();
		 
	}
	
	public void updateFine(int id, double fine)
	{
		Relation r = em.find(Relation.class,id);
		double fineUpdate =r.getFine() + fine;
		 em.getTransaction().begin();
		 r.setFine(fineUpdate);
		 em.getTransaction().commit();
	}
	
	public void setNewFine(int id, double fine)
	{
		Relation r = em.find(Relation.class,id);
		em.getTransaction().begin();
		r.setFine(fine);
		em.getTransaction().commit();
	}
	
	public void deleteRelation(int id)
	{	 
		 Relation r = em.find(Relation.class, id);
		 em.getTransaction().begin();
		 em.remove(r);
		 em.getTransaction().commit();	 
	}
	
	private EntityManager getEntityManager() 
	{
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("System");
	    EntityManager em = emf.createEntityManager();
	    return em;
	}
}
