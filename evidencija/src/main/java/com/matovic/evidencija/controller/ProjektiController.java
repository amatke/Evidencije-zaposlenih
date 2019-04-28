package com.matovic.evidencija.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matovic.evidencija.model.Projekti;
import com.matovic.evidencija.repositories.ProjektiRepositories;

@Controller
public class ProjektiController {

	@Autowired
	private ProjektiRepositories projektiRepositories; 
	
	@RequestMapping("/projekti")
	public String showProjekti(ModelMap modelMap) {
		
		modelMap.addAttribute("projektiLista", projektiRepositories.findAll());
		
		return "projekti-page";
	}
	
	
	@RequestMapping("/projekatForm")
	public String showProjekatForm() {
		
		return "projektiForm-page";
	}
	
	@RequestMapping("/insertProjekat")
	public String insertProjekat(@ModelAttribute Projekti projekat) {
		
		System.out.println(projekat);
		
		projektiRepositories.save(projekat);
		
		return "home-page";
	}
	
	
}
