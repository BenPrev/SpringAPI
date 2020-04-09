package com.cesi.group2.Madera;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MaderaController {
	@Autowired
	private ClientRepository clientRepository;
	private ProjetRepository projetRepository;
	private DevisRepository devisRepository;
	private CommercialRepository commercialRepository;
	private MaderaModuleRepository maderaModuleRepository;
	
	@PostMapping(path="/client/add")
	public @ResponseBody String ajoutClient(@RequestParam String refClient, @RequestParam String nom, @RequestParam String email) {
		Client client = new Client();
		client.setRefClient(refClient);
		client.setNom(nom);
		client.setEmail(email);
		clientRepository.save(client);
		return "Saved";
	}
	
	@PostMapping(path="/client/ajoutProjet")
	public @ResponseBody String ajoutProjet(@RequestParam String refClient, @RequestParam String refProjet) {
		Projet projet = new Projet();
		projet.setRefClient(refClient);
		projet.setRefProjet(refProjet);
		projetRepository.save(projet);
		return "Saved";
	}
	
	@PostMapping(path="/projet/addDevis")
	public @ResponseBody String ajoutDevis(@RequestParam String refDevis, @RequestParam List<MaderaModule> listModule, @RequestParam String refProjet, @RequestParam String refCommercial) {
		Devis devis = new Devis();
		devis.setListModule(listModule);
		devis.setRefDevis(refDevis);
		devis.setRefProjet(refProjet);
		devis.setRefCommercial(refCommercial);
		devisRepository.save(devis);
		return "Saved";
	}
	
	@PostMapping(path="/commercial/add")
	public @ResponseBody String ajoutCommercial(@RequestParam String refCommercial, @RequestParam String nom) {
		Commercial commercial = new Commercial();
		commercial.setNom(nom);
		commercial.setRefCommercial(refCommercial);
		commercialRepository.save(commercial);
		return "Saved";
	}
	
	@PostMapping(path="/client/delete")
	public @ResponseBody String supprimerClient(@RequestParam String refClient) {
		//!!! on peut avoir une liste de projet et une liste de devis par projet
		devisRepository.deleteByRefProjet(projetRepository.findByRefClient(refClient).getRefProjet());
		projetRepository.deleteByRefProjet(projetRepository.findByRefClient(refClient).getRefProjet());
		clientRepository.deleteByRefClient(refClient);
		return "Deleted";
	}
	
	@PostMapping(path="/devis/delete")
	public @ResponseBody String supprimerDevis(@RequestParam String refDevis) {
		devisRepository.deleteByRefDevis(refDevis);
		return "Deleted";
	}
	
	@PostMapping(path="/projet/delete")
	public @ResponseBody String supprimerProjet(@RequestParam String refProjet) {
		projetRepository.deleteByRefProjet(refProjet);
		//supprimer les devis associes au projet
		return "Deleted";
	}
	
	@PostMapping(path="commercial/delete")
	public @ResponseBody String supprimerCommercial(@RequestParam String refCommercial) {
		//supprimer les devis associe au commercial ou mettre ref commercial a null
		commercialRepository.deleteByRefCommercial(refCommercial);
		return "Deleted";
	}
	
	@PostMapping(path="devis/etat")
	public String changeEtatDevis(@RequestParam String refDevis, @RequestParam String etat) {
		Devis devis = devisRepository.findByRefDevis(refDevis);
		devis.setEtat(etat);
		devisRepository.save(devis);
		return "Saved";
	}
	
	@GetMapping(path="client/all")
	public @ResponseBody Iterable<Client> getAllClient(){
		return clientRepository.findAll();
	}
	
	@GetMapping(path="projet/all")
	public @ResponseBody Iterable<Projet> getAllProjet(String refClient){
		return projetRepository.findAllByRefClient(refClient);
	}
	
	@GetMapping(path="devis/all")
	public @ResponseBody Iterable<Devis> getAllDevis(String refProjet){
		return devisRepository.findAllByRefProjet(refProjet);
	}
	
	@GetMapping(path="commercial/all")
	public @ResponseBody Iterable<Commercial> getAllCommercial(){
		return commercialRepository.findAll();
	}
	
}
