package com.TestCase;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.UserDao;
import com.domain.User;

/*import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;*/


public class UserDaoTest 
   
{
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static UserDao userDao;
	@Autowired
	private static User user;
	@BeforeClass
	public static void abcd()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.*"); 
		
		context.refresh();
	
		userDao = (UserDao)context.getBean("userDao");
		user = (User)context.getBean("user");
	}
	@Test
	public void saveUserTestCase()
	{
		user = new User();
		user.setEmailID("dipika@gmail.com");
		user.setMobile("666666666");
		user.setName("dipika Ghatak");
		user.setPwd("dipika@123");
		
	  boolean status = 	userDao.save(user);
	  
	  assertEquals("save user test case", true, status);
	}
	
	
	@Test
	public void updateUserTestCase()
	{
		user.setEmailID("jas@gmail.com");
		user.setMobile("888888888");
		boolean status = userDao.update(user);
		assertEquals("update test case", true,status );
	}
	
	@Test
	public void getUserSuccessTestCase()
	{
		
	user= userDao.get("karan@gmail.com");
	
	assertNotNull("get user test case", user);
	}
	
	@Test
	public void getUserFailureTestCase()
	{
		
	user= userDao.get("jaya@gmail.com");
	
	assertNull("get user test case", user);
	}
	
	@Test
	public void deleteUserSuccessTestCase()
	{
	boolean status =	userDao.delete("jaskaran1@gmail.com");
	assertEquals("delete user succss test case" , true, status);
	
	}
	
	@Test
	public void deleteUserFailureTestCase()
	{
	boolean status =	userDao.delete("arpith@gmail.com");
	assertEquals("delete user failure test case" , false, status);
	
	}
	
	
	@Test
	public void getAllUsersTestCase()
	{
	List<User>	users = userDao.list();
	
	assertEquals("get all users " , 3, users.size() );
	
	}
	@Test
	public void validateCredentailsTestCase()
	{
	user = 	userDao.validate("jaskaran@gmail.com", "jas@1234");
	assertNotNull("Validate test case",user );
	
	}
	
	
}
