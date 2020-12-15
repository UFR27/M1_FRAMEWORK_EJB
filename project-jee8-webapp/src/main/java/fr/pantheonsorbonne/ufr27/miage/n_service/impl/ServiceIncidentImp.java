package fr.pantheonsorbonne.ufr27.miage.n_service.impl;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import java.time.LocalTime;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.IncidentJAXB;
import fr.pantheonsorbonne.ufr27.miage.n_jpa.Incident;
import fr.pantheonsorbonne.ufr27.miage.n_jpa.Incident.CodeEtatIncident;
import fr.pantheonsorbonne.ufr27.miage.n_jpa.Incident.CodeTypeIncident;
import fr.pantheonsorbonne.ufr27.miage.n_mapper.IncidentMapper;
import fr.pantheonsorbonne.ufr27.miage.n_repository.IncidentRepository;
import fr.pantheonsorbonne.ufr27.miage.n_service.ServiceIncident;
import fr.pantheonsorbonne.ufr27.miage.n_service.ServiceMajDecideur;

@ManagedBean
@RequestScoped
public class ServiceIncidentImp implements ServiceIncident {
	@Inject
	ServiceMajDecideur serviceMajDecideur;
	
	@Inject
	IncidentRepository incidentRepository;
	
	@Override
	public boolean creerIncident(int idTrain, IncidentJAXB inc) {
		Incident i = IncidentMapper.mapIncidentJAXBToIncident(inc);
		incidentRepository.creerIncident(idTrain, i);
		serviceMajDecideur.decideMajRetardTrainLorsCreationIncident(idTrain, estimationTempsRetard(i.getTypeIncident()));
		return false;
	}

	@Override
	public boolean majEtatIncident(int idTrain, int etatIncident) {
		incidentRepository.updateEtatIncident(idTrain, etatIncident);
		Incident i = incidentRepository.getIncidentByIdTrain(idTrain);
		
		if(etatIncident == CodeEtatIncident.EN_COURS.getCode()) {
			serviceMajDecideur.decideMajTrainEnCours(idTrain, estimationTempsRetard(i.getTypeIncident()));
			return true;
		}else if(etatIncident == CodeEtatIncident.RESOLU.getCode()){
			serviceMajDecideur.decideMajTrainFin(idTrain);
			return true;
		}

		return false;
	}


	private LocalTime estimationTempsRetard(int codeTypeIncident) {
		return CodeTypeIncident.getTempEstimation(codeTypeIncident);
	}
}