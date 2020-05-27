package com.project.model;

import java.time.LocalDateTime;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 

public class Zadanie {
	

	private Integer zadanieId;
	
	private String nazwa;
	
	private Integer kolejnosc;
	
	private String opis;
	
	private LocalDateTime dataCzasDodania;
	
	private Projekt projekt;
	
	public Projekt getProjekt() {
		return projekt;
	}
	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}
	public Integer getZadanieId() {
		return zadanieId;
	}
	public void setZadanieId(Integer zadanieId) {
		this.zadanieId = zadanieId;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public Integer getKolejnosc() {
		return kolejnosc;
	}
	public void setKolejnosc(Integer kolejnosc) {
		this.kolejnosc = kolejnosc;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public LocalDateTime getDataCzasDodania() {
		return dataCzasDodania;
	}
	public void setDataCzasDodania(LocalDateTime dataCzasDodania) {
		this.dataCzasDodania = dataCzasDodania;
	}
	public Zadanie() {
		super();
	}
	public Zadanie(String nazwa, Integer kolejnosc, String opis) {
		super();
		this.nazwa = nazwa;
		this.kolejnosc = kolejnosc;
		this.opis = opis;
	}
	
}
