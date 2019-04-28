package com.matovic.evidencija.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matovic.evidencija.model.Zaposleni;

public interface ZaposleniRepositories extends JpaRepository<Zaposleni, Long> {

	
	//radi
	//@Query("SELECT new com.matovic.evidencija.dto.UtrosenoVremeDTO(u.firstName, u.lastName, e.utrosenoVreme) FROM Zaposleni u, Evidencija e WHERE u.id = e.worker")
	//public UtrosenoVremeDTO fetch_UtrosenoVremeDTO();
	
	//radi
/*	@Query(value = "SELECT * FROM zaposleni WHERE id=2", nativeQuery = true)
	public Zaposleni fetch_UtrosenoVremeDTO();*/
	


	// WHERE zaposleni.project = evidencija.worker
	//@Query("SELECT evidencija FROM Zaposleni zaposleni JOIN Evidencija evidencija ON zaposleni.id = evidencija.worker WHERE zaposleni.firstName = ?1")
	@Query("SELECT z FROM Zaposleni z WHERE z.firstName = ?1")
	public List<Zaposleni> fetch_zaposleniByFirstName(String firstName);
	

}
