package com.TestCase;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.ProductDao;
import com.domain.Product;
public class ProductDaoTest {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static ProductDao productdao;
	@Autowired
	private static Product product;
	@BeforeClass
	public static void abcd()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.*"); 
		
		context.refresh();
		
		productdao = (ProductDao)context.getBean("productdao");
		product = (Product)context.getBean("product");
	}
	@Test
	public void saveProductTestCase()
	{
		product = new Product();
		product.setId("Men-002");
		
		product.setName("Shirts");
		product.setDescription("This is Shirts category");
		product.setCategoryId("Men-001");
		product.setSupplierID("SUP-001");
		product.setPrice(5000);
		
		
	  boolean status = 	( productdao.save(product));
	  
	  assertEquals("save category test case", true, status);
	}
	
	
	@Test
	public void updateProductTestCase()
	{
		product.setId("Mob-001");
		product.setName("MobileProduct");
		product.setDescription("This is a new Mobile Product");
		boolean status = productdao.update(product);
		assertEquals("update test case", true,status );
	}
	
	@Test
	public void getProductSuccessTestCase()
	{
		
		product=  productdao.get("Mob-001");
	
	assertNotNull("get product test case", product);
	}
	
	@Test
	public void getProductFailureTestCase()
	{
		
		product=  productdao.get("Mob-001");
	
	assertNull("get product test case", product);
	}
	
	@Test
	public void deleteProductSuccessTestCase()
	{
	boolean status =	 productdao.delete("Men-001");
	assertEquals("delete product success test case" , true, status);
	
	}
	
	@Test
	public void deleteProductFailureTestCase()
	{
	boolean status =	productdao.delete("Mob-001");
	assertEquals("delete product failure test case" , false, status);
	
	}
	
	
	@Test
	public void getAllProductsTestCase()
	{
	List<Product>	categorys = productdao.list();
	
	assertEquals("get all users " , 3, categorys.size() );
	
	}
}
