package test.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.jpa.entities.Projet;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long>{

}
