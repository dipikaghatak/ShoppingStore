package com.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CartDao;
import com.Dao.ProductDao;
import com.domain.Cart;
import com.domain.Product;

@Controller
public class CartController {
	Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	private CartDao cartdao;
	@Autowired
	private ProductDao productdao;
	@Autowired 
	private Cart cart;
	@Autowired  private Product product;
	@Autowired 
	private HttpSession httpsession;
	@GetMapping("/buy")
	public ModelAndView order()
	{
		ModelAndView mv = new ModelAndView("home");
		//there should be one update method which take emailid as parameter
		String loggedInUserId = (String)httpsession.getAttribute("loggedInUserId");
		if (cartdao.update(loggedInUserId))
		{
			
			mv.addObject("successMessage", "Your order placed successfully");
		}
		else
		{
			mv.addObject("errorMessage", "Your order not  placed successfully");
		}
		return mv;
		
	}
	@PostMapping("/product/cart/add")
	public ModelAndView addToCart(@RequestParam String productName,
			@RequestParam int price, @RequestParam String quantity)
	
	{
		ModelAndView mv = new ModelAndView("home");
		String loggedInUserId = (String) httpsession.getAttribute("loggedInUserId");
		if(loggedInUserId==null)
		{
			mv.addObject("errorMessage", "Please login to add any product to cart");
			return mv;
		}
		
		cart.setEmailID(loggedInUserId);
		cart.setPrice(price);
		cart.setQuantity(Integer.parseInt(quantity));
		
		if(cartdao.save(cart))
		{
			mv.addObject("successMessage", "The product add to cart successfully");
		}
		else
		{
			mv.addObject("errorMessage", "Could not add the product to cart..please try after some time");
		}
		return mv;
		
	}
	
	@GetMapping("/cart/add/{productId}")
	public ModelAndView addToCart(
			@PathVariable String productId	)
	
	{
		//ModelAndView mv = new ModelAndView("home");
		ModelAndView mv = new ModelAndView("redirect:/");
		String loggedInUserId = (String) httpsession.getAttribute("loggedInUserId");
		if(loggedInUserId==null)
		{
			mv.addObject("errorMessage", "Please login to add any product to cart");
			return mv;
		}
		//get the other details of product from productDAO.get()
		product = productdao.get(productId);
		
		cart.setEmailID(loggedInUserId);
		cart.setPrice(product.getPrice());
		
		cart.setProductName(product.getName());
		cart.setQuantity(1);
		
		if(cartdao.save(cart))
		{
			mv.addObject("successMessage", "The product add to cart successfully");
		}
		else
		{
			mv.addObject("errorMessage", "Could not add the product to cart..please try after some time");
		}
		return mv;
		
	}
	//get my cart details
	@GetMapping("/mycart/")
	public ModelAndView getMyCartDetails()
	{
		log.debug("Starting of the method getMyCartDetails");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedMyCart", true);
		//it will return all the products which are added to cart
		String loggedInUserId = (String) httpsession.getAttribute("loggedInUserId");
		log.info("Logged in user id : " + loggedInUserId);
		if(loggedInUserId==null);
		{
			mv.addObject("errorMessage", "Please login to see your cart details");
		}	
		
		
		List<Cart> cartList = cartdao.list(loggedInUserId);
		mv.addObject("cartList", cartList);
		log.debug("not of products in cart " + cartList.size());
		 log.debug("Ending of the method getMyCartDetails");
		return mv;
	}
	@GetMapping("/mycart")
	public ModelAndView myCart()
	{
		ModelAndView mv = new ModelAndView("home");
		return mv.addObject("isUserClickedMyCart", true);
	
	
}
}
