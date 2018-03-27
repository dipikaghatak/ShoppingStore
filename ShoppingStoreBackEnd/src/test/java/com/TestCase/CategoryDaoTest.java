package com.TestCase;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.CategoryDao;
import com.domain.Category;

public class CategoryDaoTest {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static CategoryDao CategoryDao;
	@Autowired
	private static Category category;
	@BeforeClass
	public static void abcd()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.*"); 
		
		context.refresh();
			
		CategoryDao = (CategoryDao)context.getBean("CategoryDao");
		category = (Category)context.getBean("category");
	}
	@Test
	public void saveCategoryTestCase()
	{
		category = new Category();
		category.setCid("Mob-001");
		
		category.setName("Mobile");
		category.setDescription("This is mobile category");
		
	  boolean status = 	( CategoryDao.save(category));
	  
	  assertEquals("save category test case", true, status);
	}
	
	
	@Test
	public void updateCategoryTestCase()
	{
		category.setCid("Mob-001");
		category.setName("MobileCategory");
		category.setDescription("This is a new Mobile Category");
		boolean status = CategoryDao.update(category);
		assertEquals("update test case", true,status );
	}
	
	@Test
	public void getCategorySuccessTestCase()
	{
		
	category=  CategoryDao.get("Mob-001");
	
	assertNotNull("get category test case", category);
	}
	
	@Test
	public void getCategoryFailureTestCase()
	{
		
	category=  CategoryDao.get("Mob-001");
	
	assertNull("get category test case", category);
	}
	
	@Test
	public void deleteCategorySuccessTestCase()
	{
	boolean status =	 CategoryDao.delete("Mob-001");
	assertEquals("delete category succss test case" , true, status);
	
	}
	
	@Test
	public void deleteCategoryFailureTestCase()
	{
	boolean status =	CategoryDao.delete("Mob-001");
	assertEquals("delete category failure test case" , false, status);
	
	}
	
	
	@Test
	public void getAllCategorysTestCase()
	{
	List<Category>	categorys = CategoryDao.list();
	
	assertEquals("get all usres " , 3, categorys.size() );
	
	}

}
