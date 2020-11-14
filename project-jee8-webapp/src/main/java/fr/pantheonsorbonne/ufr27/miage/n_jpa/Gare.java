package fr.pantheonsorbonne.ufr27.miage.n_jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Gare {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String[] getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(String[] coordonnees) {
		this.coordonnees = coordonnees;
	}
	String nom;
	String[] coordonnees;
	
}
