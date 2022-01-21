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
	public List<Utilisateur> findUtilisateursByCandidature(Long id_candidature) {
		return utilisateurRepository.fonction2(id_candidature);
	}

	@Override
	public List<Utilisateur> findFreelancerByProjet(Long projet_id_projet) {
		return utilisateurRepository.fonction3(projet_id_projet);
	}

	@Override
	public Double findMoyenneByFreelancer(String role) {
		List<Double> listeNoteFreelancer = utilisateurRepository.fonction4(role);
		Integer taille = listeNoteFreelancer.size();
		Double sum=0.0;
		for (Double note : listeNoteFreelancer)
		{
			sum+=note;
		}
		return sum/taille;
	}

	@Override
	public Double findMoyenneByJobOwner(String role) {
		List<Double> listeNoteJobOwner = utilisateurRepository.fonction4(role);
		Integer taille = listeNoteJobOwner.size();
		Double sum=0.0;
		for (Double note : listeNoteJobOwner)
		{
			sum+=note;
		}
		return sum/taille;
	}

	@Override
	public Integer nombreFreelancer(String libelle) {
		return utilisateurRepository.fonction5(libelle);
	}

	@Override
	public Integer nombreJobOwner(String libelle) {
		return utilisateurRepository.fonction5(libelle);
	}
	
	
}