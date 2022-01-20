package test.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import test.jpa.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>
{
	final String commandeSQL="SELECT * FROM utilisateur WHERE id_utilisateur IN "
			+ "	(SELECT id_utilisateur FROM profil WHERE id_role IN"
			+ "(SELECT id_role FROM role WHERE libelle =?1 ))";
	@Query(
			value=commandeSQL,
			nativeQuery = true
	)
	List<Utilisateur> fonction(String Role);
}
