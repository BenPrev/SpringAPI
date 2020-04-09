package com.cesi.group2.Madera;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Devis {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String refDevis, refProjet, refCommercial, etat;
	private List<MaderaModule> listModule;
	private Date dateCreation, dateValidation;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRefDevis() {
		return refDevis;
	}
	public void setRefDevis(String refDevis) {
		this.refDevis = refDevis;
	}
	public String getRefProjet() {
		return refProjet;
	}
	public void setRefProjet(String refProjet) {
		this.refProjet = refProjet;
	}
	public String getRefCommercial() {
		return refCommercial;
	}
	public void setRefCommercial(String refCommercial) {
		this.refCommercial = refCommercial;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public List<MaderaModule> getListModule() {
		return listModule;
	}
	public void setListModule(List<MaderaModule> listModule) {
		this.listModule = listModule;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateValidation() {
		return dateValidation;
	}
	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}
	
	
	

}
