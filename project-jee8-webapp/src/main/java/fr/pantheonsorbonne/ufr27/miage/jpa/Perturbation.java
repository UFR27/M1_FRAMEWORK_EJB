package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Perturbation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
   
    protected String type;
   
    protected LocalDateTime perturbationTemps;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getPerturbationTemps() {
		return perturbationTemps;
	}

	public void setPerturbationTemps(LocalDateTime perturbationTemps) {
		this.perturbationTemps = perturbationTemps;
	}
}