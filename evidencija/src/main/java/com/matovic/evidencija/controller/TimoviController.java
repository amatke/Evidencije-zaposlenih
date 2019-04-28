package com.matovic.evidencija.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matovic.evidencija.model.Timovi;
import com.matovic.evidencija.repositories.TimoviRepositories;

@Controller
public class TimoviController {

	@Autowired
	private TimoviRepositories timoviRepositories;
	
	@RequestMapping("/timovi")
	public String showTimovi(ModelMap modelMap) {
		
		modelMap.addAttribute("timoviLista", timoviRepositories.findAll());
		
		return "timovi-page";
	}
	
	
	@RequestMapping("/timForm")
	public String timFormInsert() {

		return "timoviForm-page";
	}
	
	
	@RequestMapping("/insertTim")
	public String insertTim(@ModelAttribute Timovi tim) {

		timoviRepositories.save(tim);
		
		System.out.println(tim);
		
		return "home-page";
	}
}
