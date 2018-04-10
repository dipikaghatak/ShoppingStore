package com.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.domain.Category;
import com.domain.Product;
import com.domain.Supplier;
@Controller

public class AdminController {

	private static Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private Category category;
	@Autowired
	private CategoryDao categorydao;
	@Autowired
	private ProductDao productdao;
	@Autowired
	private Product product;
	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDao supplierdao;
	@Autowired
	HttpSession httpsession;
	
	@GetMapping("/managecategories")
	public ModelAndView adminClickedCategories()
	{
		ModelAndView mv = new ModelAndView("home");
		
		String loggedInUserId= (String)httpsession.getAttribute("loggedInUserId");
		if(loggedInUserId==null)
		{
			
			mv.addObject("errorMessage", "Please login to add to cart");
			return mv;
		}
		Boolean isAdmin= (Boolean)httpsession.getAttribute("isAdmin");
		if(isAdmin==null || isAdmin==false)
		{
			mv.addObject("errorMessage", "You Are not authorized to do this operation");
			return mv;
		}
		log.debug("starting of the method admincClickedCategories");
		 mv.addObject("isAdminClickedManageCategories", true);
		List <Category> categories = categorydao.list();
		httpsession.setAttribute("categories", categories);
		log.debug("ending of the method admincClickedCategories");
		return mv;
	}
	@GetMapping("/managesuppliers")
	public ModelAndView adminClickedSuppliers()
	{
		log.debug("starting of the method admincClickedSupplier");
		ModelAndView mv = new ModelAndView("home");
		 mv.addObject("isAdminClickedManageSuppliers", true);
		List <Supplier> suppliers = supplierdao.list();
		httpsession.setAttribute("suppliers", suppliers);
		log.debug("ending of the method admincClickedSupplier");
		return mv;
		
	}
	@GetMapping("/manageproducts")
	public ModelAndView adminClickedProducts()
	{
		log.debug("starting of the method admincClickedProducts");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedManageProducts", true);
		List <Category> categories = categorydao.list();
		List <Supplier> suppliers = supplierdao.list();
		List <Product> products = productdao.list();
		httpsession.setAttribute("categories", categories);
		httpsession.setAttribute("suppliers", suppliers);
		httpsession.setAttribute("products", products);
		log.debug("ending of the method admincClickedProducts");
		return mv;
	}
}
