package com.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.domain.Category;
import com.domain.Product;
import com.domain.Supplier;

import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
@Controller
public class ProductController {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private Product product;
	@Autowired
	private CategoryDao categorydao;
	
@Autowired
HttpSession httpsession;
	
	@Autowired
	private SupplierDao supplierDao;
	
	
	

	
	/*@RequestMapping(name="/product/get/{id}", method = RequestMethod.GET)
	public ModelAndView getProduct(@RequestParam("id")String id)
	{
	
		product = productDao.get(id);
		
		
		ModelAndView mv = new ModelAndView("home");
		return mv.addObject("product", product);
	}*/
	
@PostMapping("/product/save")
	

	public ModelAndView saveProduct(@RequestParam("Pid") String Pid,
									@RequestParam("name")String name,
									@RequestParam("description") String description,
									@RequestParam("price") String price,
									@RequestParam("categoryID") String categoryID,
									@RequestParam("supplierID") String supplierID)
	{
	
				ModelAndView mv = new ModelAndView("redirect:/manageproducts");
				product.setPid(Pid);;
				product.setName(name);
				product.setDescription(description);
				
				price = price.replace(",","");
				product.setPrice(Integer.parseInt(price));
				//product.setCategory(categoryDAO.get(categoryID));
				//product.setSupplier(supplierDAO.get(supplierID));
				product.setCategoryId(categoryID);
				product.setSupplierID(supplierID);;
					
		if(productDao.save(product))
		{
	
			mv.addObject("productsuccessMessage", "The product saved successfully");
		}
		else
		{
		
			mv.addObject("producterrorMessage", "could not save the product");
		}
		return mv;
	}
	
@PutMapping("/product/update")


public ModelAndView updateProduct(@ModelAttribute Product product)
{
	
			ModelAndView mv = new ModelAndView("home");

	if(productDao.update(product)==true)
	{

		mv.addObject("successMessage", "The product updated successfully");
	}
	else
	{
		
		mv.addObject("errorMessage", "could not updated the product");
	}
	return mv;
}

/*@GetMapping(name="/product/delete")
public ModelAndView deleteProduct(@RequestParam String Pid) {
System.out.println("going to delete product : " + Pid);
{
	ModelAndView mv = new ModelAndView("redirect:/manageproducts");
	
	if( productDao.delete(Pid)== true)
	{
		
		mv.addObject("successMessage", "The product deleted successfully");
	}
	else
	{
		
		mv.addObject("errorMessage", "could not updated the product");
	}
	return mv;
}
	
	/*@GetMapping ("/product/edit")
	public ModelAndView editProduct(@RequestParam String Pid)
	{
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		// based on product id fetch product details.
		product = productDao.get(Pid);
		// mv.addObject("selectedProduct", product);
		httpsession.setAttribute("selectedProduct", product);
	
		return mv;
	}
	*/

@GetMapping("/products")
public ModelAndView getAllProducts()
{
	ModelAndView mv = new ModelAndView("home");
	List<Product> products = productDao.list();
	return mv.addObject("products", products);
	
}

  /*@GetMapping("/product/edit") public ModelAndView editProduct(@RequestParam
  String Pid) { ModelAndView mv = new
  ModelAndView("redirect:/manageproducts");
  
  product = productDao.get(Pid);
  
  httpsession.setAttribute("product", product); return mv;
  
  }*/
 
}