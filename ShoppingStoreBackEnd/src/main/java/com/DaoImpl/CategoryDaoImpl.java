package com.DaoImpl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.CategoryDao;
import com.domain.Category;


@Transactional
@Repository("categoryDAO") 
public class CategoryDaoImpl implements CategoryDao {
	
	
	@Autowired
	
	private SessionFactory sessionFactory;
	@Autowired
	private Category category;
	public boolean save(Category category) {
	try{

		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
		
	}

	public boolean update(Category category) 
	{
		if (category.getCid()==null)
			return false;
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}	
		
	}

	public Category get(String id) 
	{
		
		return sessionFactory.getCurrentSession().get(Category.class, id);
		
	}

	public boolean delete(String emailID)
	{
		try 
		{
			category =get(emailID);
			if(category== null)
			{
			return false;
			}
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
			
		catch (HibernateException e)
		{
			
			e.printStackTrace();
			return false;
		}	
	}

	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
		
	}
}
