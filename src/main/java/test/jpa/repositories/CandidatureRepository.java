package test.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.jpa.entities.Candidature;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {

}
