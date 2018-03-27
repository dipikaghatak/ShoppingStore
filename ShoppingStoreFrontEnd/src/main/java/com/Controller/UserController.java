package com.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.UserDao;
import com.domain.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private User user;

	@Autowired
	HttpSession httpSession;
	
	
	@PostMapping("validate")
	public ModelAndView validate(@RequestParam("uname") String username, @RequestParam("psw") String password)
	{
		ModelAndView mv = new ModelAndView("home");
		
		user= userDao.validate(username, password);
		
		
		if (user == null)
		{
			
			mv.addObject("error message", "Invalid credentials...Please try again");
		}
		else
		{
			//mv.addObject("welcomeMessage","Welcome Mr/Ms:"+ user.getName());
			httpSession.setAttribute("welcomeMessage", "Welcome Mr./Ms " + user.getName());
			
			if(user.getRole()=='A')
			{
				httpSession.setAttribute("isAdmin", true);
			}
			
		}
		
		return mv;
			
			
			
			
			
	}

@PostMapping("register")
 public ModelAndView register (@RequestParam("user") String name,@RequestParam("pwd")String password,@RequestParam("emailID")String EmailID,@RequestParam("mobile")String Mobile)
 {
	ModelAndView mv = new ModelAndView("home");
	user = new User();
	user.setName(name);
	user.setPwd(password);
	user.setEmailID(EmailID);
	user.setMobile(Mobile);
	System.out.println("value"+ user.getMobile()+user.getName()+user.getPwd()+user.getRole()+user.getRegisterDate());

if(userDao.save(user)==false)
{
 mv.addObject("registratonFailed", "Failed");	
}
else
{
	mv.addObject("registrationSuccessful", "Success");
 }
return mv;

}
}