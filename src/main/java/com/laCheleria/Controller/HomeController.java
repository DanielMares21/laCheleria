package com.laCheleria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	 @GetMapping("/inicio")
	   public String mostrarIndex() {
	      return "index";
	   }

}
