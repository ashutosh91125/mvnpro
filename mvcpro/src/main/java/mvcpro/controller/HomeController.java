package mvcpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		System.out.println("This is home URL");
		
		
		List<String> details = new ArrayList<String>();
		details.add("Ashutosh");
		details.add("Mishra");
		details.add("Kamalpur");
		
		 model = model.addAttribute("details", details);
		
		return "index";
	}
	
}
