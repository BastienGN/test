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

import test.jpa.entities.Candidature;
import test.jpa.services.interfaces.ICandidatureService;

@RestController
@CrossOrigin
public class CandidatureController {
	@Autowired
	ICandidatureService candidatureService;
	
	@GetMapping("/candidatures")
	public List<Candidature> findAll() {
		return candidatureService.findAll();
	}

	@GetMapping("/candidatures/{idC}")
	public Candidature findOne(@PathVariable(value = "idC") Long idCandidature) {
		return candidatureService.findOne(idCandidature);
	}
	
	@PostMapping("/candidatures")
    public Candidature saveCandidature(@RequestParam(name = "statut",required = false) String statut, 
    		@RequestParam(name = "lettreMotivation",required = false) String lettreMotivation) {
            Candidature currentCandidature=new Candidature();
            currentCandidature.setStatut(statut);
            currentCandidature.setLettreMotivation(lettreMotivation);
            return candidatureService.save(currentCandidature);
    }

	@PutMapping("/candidatures/{idC}")
	public Candidature updateCandidature(@PathVariable("idC") Long idCandidature,
			@RequestBody Candidature candidature) {
		Candidature currentCandidature = candidatureService.findOne(idCandidature);
        currentCandidature.setStatut(candidature.getStatut());		
        currentCandidature.setLettreMotivation(candidature.getLettreMotivation());
		return candidatureService.save(currentCandidature);
	}

	@DeleteMapping("/candidatures/{idCandidature}")
	public void deleteCandidature(@PathVariable("idCandidature") Long idCandidature) {
		candidatureService.delete(idCandidature);
	}

}
