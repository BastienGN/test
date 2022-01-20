package test.jpa.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Projet implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idProjet;
	private String titre;
	private String description;
	private double salaire;
	private String statut;
	private String username;//username du jobOwner 
	
	@OneToMany(mappedBy="projet")
	@Transient
	private Set<Candidature> candidature=new HashSet<>();
	
	public Projet() {
	}

	public Projet(String titre, String description, double salaire, String statut) {
		this.titre = titre;
		this.description = description;
		this.salaire = salaire;
		this.statut = statut;
	}

	public Long getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(Long idProjet) {
		this.idProjet = idProjet;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Set<Candidature> getCandidature() {
		return candidature;
	}

	public void setCandidature(Set<Candidature> candidature) {
		this.candidature = candidature;
	}

	@Override
	public String toString() {
		return "Projet [idProjet=" + idProjet + ", titre=" + titre + ", description=" + description + ", salaire="
				+ salaire + ", statut=" + statut + "]";
	}
	
}
