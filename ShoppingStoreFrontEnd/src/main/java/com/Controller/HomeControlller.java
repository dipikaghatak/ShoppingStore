package com.Controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDao;
import com.domain.Category;

@Controller
public class HomeControlller {
	@Autowired
	private CategoryDao categorydao;
	@Autowired
	private Category category;
	
	@Autowired
	private HttpSession httpsession;
	private static String imageDirectory = "D:\\dipika workspace\\Shopping store\\ShoppingStoreFrontEnd\\src\\main\\webapp\\resources\\images";
	@GetMapping("/")
	public ModelAndView home(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("home");
	

		List<Category> categories = categorydao.list();

		
		httpsession.setAttribute("categories", categories);
		httpsession.setAttribute("imageDirectory", imageDirectory);
		String root =request.getContextPath();
	    String imageFolder =  root + File.separator +"src" + File.separator + 
	    		"main" +File.separator +
	    		"webapp"+File.separator +
	    		"resources"+File.separator;	
	    httpsession.setAttribute("imageFolder", imageFolder);
	    //httpSession.getServletContext().getgetContextPath();
		return mv;
	}
	

	@GetMapping("/login")
	public ModelAndView login() {

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedLogin", true);
		return mv;
	}
@GetMapping("/logout")
public ModelAndView logout()
{
	//at the time of login, we add user id in http session
	//at the time of logout, we need o remove user id from httpsession
	ModelAndView mv = new ModelAndView("home");
	httpsession.invalidate();
	/*httpsession.removeAttribute("loggedInUserId");

	httpsession.removeAttribute("isLoggedIn");
	httpsession.removeAttribute("isAdmin");*/
	return mv.addObject("logoutMessage", "You are successfully logged out");

}
	@GetMapping("/register")
	public ModelAndView register() {

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedRegister", true);
		
		return mv;
	}
}
