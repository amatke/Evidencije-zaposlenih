package com.matovic.evidencija.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matovic.evidencija.model.Pozicije;

public interface PozicijeRepositories extends JpaRepository<Pozicije, Long> {

}
