package test.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.jpa.entities.Candidature;
import test.jpa.entities.Utilisateur;
import test.jpa.services.interfaces.ICandidatureService;
import test.jpa.services.interfaces.IUtilisateurService;

@RestController
@CrossOrigin
public class UtilisateurController {
    @Autowired
    IUtilisateurService utilisateurService;

    @RequestMapping(value="utilisateurs", method = RequestMethod.GET)
    public List<Utilisateur> findAll() {
        return utilisateurService.findAll();
    }
    
    @RequestMapping(value="utilisateurs/{idU}", method = RequestMethod.GET)
    public Utilisateur findOne(@PathVariable("idU") Long idUtilisateur) {
        return utilisateurService.findOne(idUtilisateur);
    }


    @RequestMapping(value = "utilisateurs", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur(
			@RequestParam(name = "nomUtilisateur",required = false) String nomUtilisateur,
    		@RequestParam(name = "prenomUtilisateur",required = false) String prenomUtilisateur
    		)
    {
    	Utilisateur currentUtilisateur = new Utilisateur();
        currentUtilisateur.setNomUtilisateur(nomUtilisateur);
        currentUtilisateur.setPrenomUtilisateur(prenomUtilisateur);
		return utilisateurService.save(currentUtilisateur);
	}

    @RequestMapping(value="utilisateurs/{idU}", method=RequestMethod.PUT)
    public Utilisateur updateUtilisateur(
    		@RequestParam(name = "idUtilisateur",required = false) Long idUtilisateur,
    		@RequestParam(name = "nomUtilisateur",required = false) String nomUtilisateur,
    		@RequestParam(name = "prenomUtilisateur",required = false) String prenomUtilisateur
    		) 
    {
    	Utilisateur currentUtilisateur =utilisateurService.findOne(idUtilisateur);
        currentUtilisateur.setNomUtilisateur(nomUtilisateur);
        currentUtilisateur.setPrenomUtilisateur(prenomUtilisateur);
		return utilisateurService.save(currentUtilisateur);
    }

    @RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.DELETE)
    public void deleteUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) {
        utilisateurService.delete(idUtilisateur);
    }
    
    @RequestMapping(value="util/{libelle_role}", method=RequestMethod.GET)
    public List<Utilisateur> findByRole(@PathVariable("libelle_role") String libelle)
    {
    	return utilisateurService.findByRole(libelle);
    }
    
    @RequestMapping(value="utilisateurscandidature/{idU}", method=RequestMethod.GET)
    public List<Utilisateur> findUtilisateursByCandidature(@PathVariable("idU") Long id_candidature)
    {
    	return utilisateurService.findUtilisateursByCandidature(id_candidature);
    }
    
    @RequestMapping(value="freelancersprojets/{idF}", method=RequestMethod.GET)
    public List<Utilisateur> findFreelancerByProjet(@PathVariable("idF") Long projet_id_projet)
    {
    	return utilisateurService.findFreelancerByProjet(projet_id_projet);
    }
    
    @RequestMapping(value="moyennefreelancer/{idF}", method=RequestMethod.GET)
    public Double findMoyenneByFreelancer(@PathVariable("idF") String libelle)
    {
    	return utilisateurService.findMoyenneByFreelancer(libelle);
    }
    
    @RequestMapping(value="moyennejobowner/{idJ}", method=RequestMethod.GET)
    public Double findMoyenneByJobOwner(@PathVariable("idJ") String libelle)
    {
    	return utilisateurService.findMoyenneByJobOwner(libelle);
    }
    
    @RequestMapping(value="nombrefreelancer/{idF}", method=RequestMethod.GET)
    public Double nombreFreelancer(@PathVariable("idF") String libelle)
    {
    	return utilisateurService.findMoyenneByFreelancer(libelle);
    }
    
    @RequestMapping(value="nombrejobowner/{idJ}", method=RequestMethod.GET)
    public Double nombreJobOwner(@PathVariable("idJ") String libelle)
    {
    	return utilisateurService.findMoyenneByJobOwner(libelle);
    }
	
}
