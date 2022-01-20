package test.jpa.services.interfaces;

import java.util.List;

import test.jpa.entities.Candidature;
import test.jpa.entities.Utilisateur;

public interface IUtilisateurService {
	List<Utilisateur> findAll();

	Utilisateur findOne(Long idUtilisateur);

	Utilisateur save(Utilisateur utilisateur);

	void delete(Long idUtilisateur);
	
	List<Utilisateur> findByRole(String libelle);
	
	List<Candidature> findByNomFreelancer(String nomFreelancer);

}
