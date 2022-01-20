package test.jpa.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import test.jpa.entities.Projet;

@Entity
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	


	@ManyToMany
	@Transient
	@JoinTable(	name = "Profil",
				joinColumns = @JoinColumn(name = "id_utilisateur", referencedColumnName = "idUtilisateur"), 
				inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole"))
	private Set<Role> roles = new HashSet<>();
	
	@ManyToMany
	@Transient
	@JoinTable(	name = "Projet_JobOwner", 
				joinColumns = @JoinColumn(name = "id_jobOwner", referencedColumnName = "idUtilisateur"), 
				inverseJoinColumns = @JoinColumn(name = "id_projet", referencedColumnName = "idProjet"))
	private Set<Projet> projets = new HashSet<>();

	public Utilisateur() {
	}
	
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + "]";
	}
}