package test.jpa.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "candidatures")
public class Candidature implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idCandidature;
	private String statut;
	private String lettreMotivation;
	private String nomFreelancer;
	private String prenomFreelancer;
	private String username;

	@ManyToOne
	@Transient
	private Projet projet;
	
	public Candidature() {
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

	public String getNomFreelancer() {
		return nomFreelancer;
	}

	public void setNomFreelancer(String nomFreelancer) {
		this.nomFreelancer = nomFreelancer;
	}

	public String getPrenomFreelancer() {
		return prenomFreelancer;
	}

	public void setPrenomFreelancer(String prenomFreelancer) {
		this.prenomFreelancer = prenomFreelancer;
	}

	
	
}
