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
	private static ProductDao ProductDao;
	@Autowired
	private static Product category;
	@BeforeClass
	public static void abcd()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit"); 
		
		context.refresh();
		
		ProductDao = (ProductDao)context.getBean("ProductDao");
		category = (Product)context.getBean("category");
	}
	@Test
	public void saveProductTestCase()
	{
		category = new Product();
		category.setPid("Mob-001");
		
		category.setName("Mobile");
		category.setDescription("This is mobile category");
		
	  boolean status = 	( ProductDao.save(category));
	  
	  assertEquals("save category test case", true, status);
	}
	
	
	@Test
	public void updateProductTestCase()
	{
		category.setPid("Mob-001");
		category.setName("MobileProduct");
		category.setDescription("This is a new Mobile Product");
		boolean status = ProductDao.update(category);
		assertEquals("update test case", true,status );
	}
	
	@Test
	public void getProductSuccessTestCase()
	{
		
	category=  ProductDao.get("Mob-001");
	
	assertNotNull("get category test case", category);
	}
	
	@Test
	public void getProductFailureTestCase()
	{
		
	category=  ProductDao.get("Mob-001");
	
	assertNull("get category test case", category);
	}
	
	@Test
	public void deleteProductSuccessTestCase()
	{
	boolean status =	 ProductDao.delete("Mob-001");
	assertEquals("delete category succss test case" , true, status);
	
	}
	
	@Test
	public void deleteProductFailureTestCase()
	{
	boolean status =	ProductDao.delete("Mob-001");
	assertEquals("delete category failure test case" , false, status);
	
	}
	
	
	@Test
	public void getAllProductsTestCase()
	{
	List<Product>	categorys = ProductDao.list();
	
	assertEquals("get all usres " , 3, categorys.size() );
	
	}
}
