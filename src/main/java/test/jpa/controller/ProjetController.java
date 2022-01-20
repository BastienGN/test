package test.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.jpa.entities.Projet;
import test.jpa.services.interfaces.IProjetService;

@RestController
@CrossOrigin
public class ProjetController {
	
	@Autowired
	IProjetService projetService;
	
	@GetMapping("/projets")
	public List<Projet> findAll() {
		return projetService.findAll();
	}

	@GetMapping("/projets/{idP}")
	public Projet findOne(@PathVariable(value = "idP") Long idProjet) {
		return projetService.findOne(idProjet);
	}
	
	@PostMapping("/projets")
    public Projet saveProjet(@RequestParam(name = "titre",required = false) String titre, 
    		@RequestParam(name = "description",required = false) String decription,
    		@RequestParam(name = "salaire",required = false) double salaire,
    		@RequestParam(name = "statut",required = false) String statut) {
            Projet currentProjet=new Projet();
            currentProjet.setTitre(titre);
            currentProjet.setDescription(decription);
            currentProjet.setSalaire(salaire);
            currentProjet.setStatut(statut);
            return projetService.save(currentProjet);
    }

	@PutMapping("/projets/{idP}")
	public Projet updateProjet(@PathVariable("idP") Long idProjet,
			@RequestBody Projet projet) {
		Projet currentProjet = projetService.findOne(idProjet);
		currentProjet.setTitre(projet.getTitre());
        currentProjet.setDescription(projet.getDescription());
        currentProjet.setSalaire(projet.getSalaire());
        currentProjet.setStatut(projet.getStatut());
		return projetService.save(currentProjet);
	}

	@DeleteMapping("/projets/{idProjet}")
	public void deleteProjet(@PathVariable("idProjet") Long idProjet) {
		projetService.delete(idProjet);
	}

}
