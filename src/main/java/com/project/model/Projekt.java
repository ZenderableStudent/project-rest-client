package com.project.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 

public class Projekt {

	private Integer projektId;
	
	private String nazwa;
	private String opis;
	private LocalDateTime dataCzasUtworzenia;
	private LocalDate dataOddania;
	private List<Zadanie> zadania;
	public List<Zadanie> getZadania() {
		return zadania;
	}
	public void setZadania(List<Zadanie> zadania) {
		this.zadania = zadania;
	}
	public Set<Student> getStudenci() {
		return studenci;
	}
	public void setStudenci(Set<Student> studenci) {
		this.studenci = studenci;
	}
	
	
	private Set<Student> studenci;
 
public Integer getProjektId() {
	return projektId;
}
public void setProjektId(Integer projektId) {
	this.projektId = projektId;
}
public String getNazwa() {
	return nazwa;
}
public void setNazwa(String nazwa) {
	this.nazwa = nazwa;
}
public String getOpis() {
	return opis;
}
public void setOpis(String opis) {
	this.opis = opis;
}
public LocalDateTime getDataCzasUtworzenia() {
	return dataCzasUtworzenia;
}
public void setDataCzasUtworzenia(LocalDateTime dataCzasUtworzenia) {
	this.dataCzasUtworzenia = dataCzasUtworzenia;
}
public LocalDate getDataOddania() {
	return dataOddania;
}
public void setDataOddania(LocalDate dataOddania) {
	this.dataOddania = dataOddania;
}
 
public Projekt() {
	
}

public Projekt(Integer projektId, String nazwa, String opis, LocalDateTime dataCzasUtworzenia, LocalDate dataOddania) {
	super();
	this.projektId = projektId;
	this.nazwa = nazwa;
	this.opis = opis;
	this.dataCzasUtworzenia = dataCzasUtworzenia;
	this.dataOddania = dataOddania;
}
public Projekt(String nazwa, String opis, LocalDate dataOddania) {
	super();
	this.nazwa = nazwa;
	this.opis = opis;
	this.dataOddania = dataOddania;
}

}