package com.matovic.evidencija.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matovic.evidencija.model.Evidencija;
import com.matovic.evidencija.model.Projekti;
import com.matovic.evidencija.model.Zaposleni;
import com.matovic.evidencija.repositories.EvidencijaRepositories;
import com.matovic.evidencija.repositories.ProjektiRepositories;
import com.matovic.evidencija.repositories.ZaposleniRepositories;

@Controller
public class EvidencijaController {

	@Autowired
	private ZaposleniRepositories zaposleniRepositories;
	
	@Autowired
	private EvidencijaRepositories evidencijaRepositories;
	
	@Autowired
	private ProjektiRepositories projektiRepositories;
	
	@RequestMapping("/evidentiraj")
	public String evidentiraj(ModelMap modelMap) {

		modelMap.addAttribute("zaposleniLista", zaposleniRepositories.findAll());
		return "evidencija-page";
	}
	
	
	@RequestMapping("/evidentirajVreme")
	public String evidentirajVreme(@RequestParam("zaposleniID") Long id, ModelMap modelMap) {

		Zaposleni worker = zaposleniRepositories.getOne(id);
		Projekti project = worker.getProject();
	

		Optional<Evidencija> evidencija = evidencijaRepositories.findById(id);
		
		//AKO ZAPOSLENI JOS NEMA EVIDENCIJU ZABELEZENU
		if (!evidencija.isPresent()) {
			Evidencija prvaEvidencija = new Evidencija();
			prvaEvidencija.setId(0L);
			prvaEvidencija.setWorker(worker);
			prvaEvidencija.setProject(project);
			
			modelMap.addAttribute("evidencija", prvaEvidencija);
		} else {
			modelMap.addAttribute("evidencija", evidencija.get());
		}
		
		return "evidencijaForm-page";
	}
	
	@RequestMapping("/updateEvidencija")
	public String updateEvidencija(@RequestParam("evidencija_id") Long evidencijaID, 
			@RequestParam("worker_id") Long worker_id,
			@RequestParam("projekat_id") Long project_id,
			@RequestParam("utrosenoVreme") int novoVreme, 
			ModelMap modelMap) {

			System.err.println("_>> evidencijaID " + evidencijaID);
			System.err.println("_>> worker_id " + worker_id);
			System.err.println("_>> project_id " + project_id);
			
			Zaposleni WORKER = zaposleniRepositories.getOne(worker_id);
			Projekti PROJECT = projektiRepositories.getOne(project_id);
		
			
		if (evidencijaID != 0) {
			
			Evidencija EVIDENCIJA = evidencijaRepositories.getOne(evidencijaID);
			EVIDENCIJA.setWorker(WORKER);
			EVIDENCIJA.setProject(PROJECT);
			EVIDENCIJA.setUtrosenoVreme(EVIDENCIJA.getUtrosenoVreme() + novoVreme);
			
			evidencijaRepositories.save(EVIDENCIJA);
		} 
		//znaci da nemamo evidenciju ovog zaposlenog
		else {
			Evidencija EVIDENCIJA = new Evidencija();
			EVIDENCIJA.setWorker(WORKER);
			EVIDENCIJA.setProject(PROJECT);
			EVIDENCIJA.setUtrosenoVreme(novoVreme);
			
			evidencijaRepositories.save(EVIDENCIJA);
		}
		
		return "home-page";
	}
	
	
	@RequestMapping("/evidencijaByName")
	public String evidencijaByName(@RequestParam("firstName") String firstName, ModelMap modelMap) {
		
		List<Zaposleni> evidencijeList =  (List<Zaposleni>) evidencijaRepositories.fetch_evidencijaByFirstName(firstName);
		modelMap.addAttribute("zaposleniAll", evidencijeList);

		if(evidencijeList.isEmpty()) {
			modelMap.addAttribute("notFound", "Nema rezultata pretrage za: " + firstName);
		}
		
		return "evidencijaPretraga-page";
	}
	
	
	
}
