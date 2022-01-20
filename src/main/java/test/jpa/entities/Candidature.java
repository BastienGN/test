package test.jpa.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Candidature implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idCandidature;
	private String statut;
	private String lettreMotivation;

	@ManyToOne
	private Projet projet;
	
	public Candidature() {
	}

	public Candidature(Long idCandidature, String statut, String lettreMotivation) {
		this.statut = statut;
		this.lettreMotivation = lettreMotivation;
	}

	public Long getIdCandidature() {
		return idCandidature;
	}

	public void setIdCandidature(Long idCandidature) {
		this.idCandidature = idCandidature;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getLettreMotivation() {
		return lettreMotivation;
	}

	public void setLettreMotivation(String lettreMotivation) {
		this.lettreMotivation = lettreMotivation;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	@Override
	public String toString() {
		return "Candidature [idCandidature=" + idCandidature + ", statut=" + statut + ", lettreMotivation="
				+ lettreMotivation + "]";
	}
	
}
