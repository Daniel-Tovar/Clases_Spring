package com.example.Proyecto1.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Proyecto1.domain.Client;



@Controller
public class IndexController {
	
	@Value(value = "${application.controller.tittle}")
	private String title;

	
	@GetMapping("/greet")
	public String getGreet(Model model) {	 
     model.addAttribute("title", this.title);
     return "greet";
	}
	
	/*@GetMapping("/clients")
	public String getClients (Model model) {
     model.addAttribute("title", this.title);
	 return "clients";	
	}*/
	
	@GetMapping("/client_form")
	public String getclient(Map<String, Object> model) {
		Client client = new Client();
		model.put("title", "Client Form");
		model.put("client",client);
		return "client_form";
	}
}
