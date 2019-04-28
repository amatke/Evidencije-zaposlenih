package com.matovic.evidencija.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matovic.evidencija.model.Evidencija;
import com.matovic.evidencija.model.Zaposleni;

public interface EvidencijaRepositories extends JpaRepository<Evidencija, Long> {

	@Query("SELECT e FROM Zaposleni e WHERE e.firstName = ?1")
	List<Zaposleni> fetch_evidencijaByFirstName(String firstName);

}
