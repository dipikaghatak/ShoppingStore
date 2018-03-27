package com.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
		 mv.addObject("isAdminClickedCategories", true);
		List <Category> categories = categorydao.list();
		httpsession.setAttribute("categories", categories);
		return mv;
	}
	@GetMapping("/managesuppliers")
	public ModelAndView adminClickedSuppliers()
	{
		ModelAndView mv = new ModelAndView("home");
		 mv.addObject("isAdminClickedSuppliers", true);
		List <Supplier> suppliers = supplierdao.list();
		httpsession.setAttribute("suppliers", suppliers);
		return mv;
		
	}
	@GetMapping("/manageproducts")
	public ModelAndView adminClickedProducts()
	{
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedProducts", true);
		List <Category> categories = categorydao.list();
		List <Supplier> suppliers = supplierdao.list();
		List <Product> products = productdao.list();
		httpsession.setAttribute("categories", categories);
		httpsession.setAttribute("suppliers", suppliers);
		httpsession.setAttribute("products", products);
		return mv;
	}
}
