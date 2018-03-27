package com.TestCase;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.SupplierDao;
import com.domain.Supplier;
public class SupplierDaoTest {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static SupplierDao supplierDao;
	@Autowired
	private static Supplier supplier;
	@BeforeClass
	public static void abcd()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.*"); 
		
		context.refresh();
		
		supplierDao = (SupplierDao)context.getBean("supplierDao");
		supplier = (Supplier)context.getBean("supplier");
	}
	@Test
	public void saveSupplierTestCase()
	{
		supplier = new Supplier();
		supplier.setSid("SUP-001");
		
		supplier.setName("BlueDart");
		supplier.setAddress("NH33, Chennai");
		
	  boolean status = 	supplierDao.save(supplier);
	  
	  assertEquals("save supplier test case", true, status);
	}
	
	
	@Test
	public void updateSupplierTestCase()
	{
		supplier = new Supplier();
		supplier.setSid("SUP-001");
		
		supplier.setName("BigC");
		supplier.setAddress("Warli, Mumbai");
		
		boolean status = supplierDao.update(supplier);
		assertEquals("update test case", true,status );
	}
	
	@Test
	public void getSupplierSuccessTestCase()
	{
		
	supplier= supplierDao.get("Sup-001");
	
	assertNotNull("get supplier test case", supplier);
	}
	
	@Test
	public void getSupplierFailureTestCase()
	{
		
	supplier= supplierDao.get("Sup-001");
	
	assertNull("get supplier test case", supplier);
	}
	
	@Test
	public void deleteSupplierSuccessTestCase()
	{
	boolean status =	supplierDao.delete("Sup-001");
	assertEquals("delete supplier succss test case" , true, status);
	
	}
	
	@Test
	public void deleteSupplierFailureTestCase()
	{
	boolean status =	supplierDao.delete("arpith@gmail.com");
	assertEquals("delete supplier failure test case" , false, status);
	
	}
	
	
	@Test
	public void getAllSuppliersTestCase()
	{
	List<Supplier>	suppliers = supplierDao.list();
	
	assertEquals("get all users " , 3, suppliers.size() );
	
	}
	
}