package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.JPAUtil;

public class BaseDao {
	public void insert(Object obj) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();
		EntityTransaction txn = manager.getTransaction();
		txn.begin();
		manager.persist(obj);
		txn.commit();
	}
	
	public <E> E select (Class<E> clazz, Serializable pk) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();
		
		try{
			E e = (E) manager.find(clazz, pk);
			return e;
		} finally {
			manager.close();
		}
	}
	
}
