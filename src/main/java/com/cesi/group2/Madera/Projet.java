package com.cesi.group2.Madera;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String refProjet, refClient;
	private List<Devis> listDevis;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRefProjet() {
		return refProjet;
	}
	public void setRefProjet(String refProjet) {
		this.refProjet = refProjet;
	}
	public String getRefClient() {
		return refClient;
	}
	public void setRefClient(String refClient) {
		this.refClient = refClient;
	}
	public List<Devis> getListDevis() {
		return listDevis;
	}
	public void setListDevis(List<Devis> listDevis) {
		this.listDevis = listDevis;
	}

}
