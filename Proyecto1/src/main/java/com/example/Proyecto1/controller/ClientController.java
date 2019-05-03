package com.example.Proyecto1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Proyecto1.domain.Client;
import com.example.Proyecto1.repository.ClientRepository;

@Controller
public class ClientController {
	
    @Autowired//@Autowired inyecta el recurso
    private ClientRepository repo;
    
    @PostMapping("/save")//post genera un body para hacer el request (mas seguro que get)
    public String insert(Client client) {
    	repo.save(client);
    	return "redirect:clients";
    }
    
    @GetMapping("/clients")//Get embebe parámetros a la url para hacer el request
    public String list (Model model) {
    	
    	model.addAttribute("title","List of Clients");
    	model.addAttribute("clients", repo.findAll());
    	return "clients";
    }
    
    
}
