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
	
	List<Utilisateur> findUtilisateursByCandidature(Long id_candidature);
	
	List<Utilisateur> findFreelancerByProjet(Long projet_id_projet);
	
	Double findMoyenneByFreelancer(String libelle);
	
	Double findMoyenneByJobOwner(String libelle);
	
	Integer nombreFreelancer(String libelle);
	
	Integer nombreJobOwner(String libelle);

}
