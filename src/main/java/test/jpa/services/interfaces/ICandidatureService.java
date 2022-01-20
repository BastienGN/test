package test.jpa.services.interfaces;

import java.util.List;
import test.jpa.entities.Candidature;

public interface ICandidatureService {
	
	List<Candidature> findAll();

	Candidature findOne(Long idCandidature);

	Candidature save(Candidature candidature);

	void delete(Long idCandidature);
	
	List<Candidature> findByNomFreelancer(String nomFreelancer);
	
}
