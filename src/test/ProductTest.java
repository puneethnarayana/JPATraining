package test;

import org.junit.Test;

import dao.BaseDao;
import entity.Customer;
import entity.Product;

public class ProductTest {
	@Test
	public void saveProduct() {
		Product c1 = new Product();
		c1.setProductName("Polo");
		c1.setQuantity(500);
		
		BaseDao dao = new BaseDao();
		dao.insert(c1);
	}
}
