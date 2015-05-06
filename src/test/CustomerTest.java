package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;

import org.junit.Test;

import util.JPAUtil;
import dao.BaseDao;
import entity.Customer;

public class CustomerTest {

	@Test
	public void saveCustomer() {
		Customer c1 = new Customer();
		c1.setName("Polo");
		c1.setEmail("polo@gmail.com");
		
		BaseDao dao = new BaseDao();
		dao.insert(c1);
	}
	
	@Test
	public void testObjectStates() {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		
	}
	
	@Test
	public void testFlushing() {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager mgr = emf.createEntityManager();
		mgr.setFlushMode(FlushModeType.COMMIT);
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		for (int i = 10; i < 20; i++) {
			Customer cust = new Customer();
			cust.setId(i);
			cust.setName("Gumnaam");
			cust.setEmail("same@mail.com");
			
			mgr.persist(cust);
		}
		
		List<Customer> list = mgr.createQuery("select c from Customer c").getResultList();
		System.out.println(list.size());
		
		txn.commit();
		mgr.close();
	}
}
