package mvcpro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import mvcpro.model.User;
import mvcpro.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void commonDataForModel(Model m) {
		m.addAttribute("Header", "Programming Practice Form");
		m.addAttribute("description", "Learning Java MVC");
	}
	
	@RequestMapping("/contact")
	public String showForm(Model m) {
		return "contact";
	}

	
	@RequestMapping(path= "/processForm", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("user") User user, Model m) {
		System.out.println(user);
		int id = this.userService.createUser(user);
		m.addAttribute("id", "User created with Id:"+ id );
		return "success";
	}
	
	@RequestMapping("/redirect1")
	public String redirectChecker() {
		System.out.println("Redirect Checker 1 is called");
		
		return "redirect:/redirect2";		
	}
	
	
	@RequestMapping("/redirect3")
	public RedirectView redirectChecker3() {
		System.out.println("Redirect Checker 3 is called");
		
		RedirectView redirectView = new RedirectView();
		
//		Note: Don't use / before rout like /redirect2 because it will redirect to root like http://localhost:8080/redirect2
		redirectView.setUrl("redirect2");
		
		return redirectView;		
	}
	
	@RequestMapping("/redirect2")
	public String redirectChecker2() {
		System.out.println("Redirect Checker 2 is called");
		
		return "/contact";
	}
	
}
