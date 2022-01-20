package test.jpa.services.interfaces;

import java.util.List;
import test.jpa.entities.Projet;

public interface IProjetService {
	
	List<Projet> findAll();

	Projet findOne(Long idProjet);

	Projet save(Projet projet);

	void delete(Long idProjet);
	
}
