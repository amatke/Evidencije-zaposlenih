package com.matovic.evidencija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matovic.evidencija.model.Zaposleni;
import com.matovic.evidencija.repositories.PozicijeRepositories;
import com.matovic.evidencija.repositories.ProjektiRepositories;
import com.matovic.evidencija.repositories.TimoviRepositories;
import com.matovic.evidencija.repositories.ZaposleniRepositories;



@Controller
public class ZaposleniController {

	@Autowired
	private ZaposleniRepositories zaposleniRepositories;
	
	@Autowired
	private TimoviRepositories timoviRepositories;
	
	@Autowired
	private PozicijeRepositories pozicijeRepositories;
	
	@Autowired
	private ProjektiRepositories projektiRepositories;
	

	@RequestMapping("/")
	public String showHomePage() {
		return "home-page";
	}
	
	@RequestMapping("/zaposleni")
	public String pageZaposleni(ModelMap modelMap) {
		
		modelMap.addAttribute("zaposleniAll", zaposleniRepositories.findAll());

		return "zaposleni-page";
	}
	
	
	@RequestMapping("/findByName")
	public String findByName(@RequestParam("firstName") String firstName, ModelMap modelMap) {
				
		List<Zaposleni> zaposleniList =  (List<Zaposleni>) zaposleniRepositories.fetch_zaposleniByFirstName(firstName);
		modelMap.addAttribute("pretraga", zaposleniList);
		
		if(zaposleniList.isEmpty()) {
			modelMap.addAttribute("notFound", "Nema rezultata pretrage za: " + firstName);
		}
				
		return "zaposleniPretraga-page";
	}
	
	@RequestMapping("/zaposleniForm")
	public String insertZaposleni(ModelMap modelMap) {
		
		modelMap.addAttribute("listaTimova", timoviRepositories.findAll());
		modelMap.addAttribute("listaPozicija", pozicijeRepositories.findAll());
		modelMap.addAttribute("listaProjekata", projektiRepositories.findAll());
		
		return "zaposleniForm-page";
	}
	
	
	@RequestMapping("/insertZaposleni")
	public String insertZaposleni(@ModelAttribute Zaposleni zaposlen) {
		
		zaposleniRepositories.save(zaposlen);
		
		System.out.println(zaposlen);
		
		return "home-page";
	}
}
