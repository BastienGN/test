package test.jpa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.jpa.entities.Candidature;
import test.jpa.entities.Utilisateur;
import test.jpa.repositories.CandidatureRepository;
import test.jpa.repositories.UtilisateurRepository;
import test.jpa.services.interfaces.IUtilisateurService;

@Service
public class UtilisateurService implements IUtilisateurService{
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Override
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findOne(Long idUtilisateur) {
		return utilisateurRepository.findById(idUtilisateur).get();
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public void delete(Long idUtilisateur) {
		utilisateurRepository.deleteById(idUtilisateur);
	}

	@Override
	public List<Utilisateur> findByRole(String libelle) {
		
		return utilisateurRepository.fonction(libelle);
	}

	@Override
	public List<Utilisateur> findByProjet(Long projet_id_projet) {
		return utilisateurRepository.fonction2(projet_id_projet);
	}

	

}