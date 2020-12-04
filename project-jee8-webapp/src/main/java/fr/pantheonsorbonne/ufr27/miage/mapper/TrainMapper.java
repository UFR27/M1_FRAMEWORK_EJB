package fr.pantheonsorbonne.ufr27.miage.mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Arret;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ObjectFactory;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Passager;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Train;
import fr.pantheonsorbonne.ufr27.miage.mapper.ArretMapper;
import fr.pantheonsorbonne.ufr27.miage.mapper.PassagerMapper;

public class TrainMapper {

	public static Train trainDTOMapper(fr.pantheonsorbonne.ufr27.miage.jpa.Train train) {
		Train trainDTO = new ObjectFactory().createTrain();
		trainDTO.setIdTrain(train.getId());
		trainDTO.setNomTrain(train.getNomTrain());
		trainDTO.setDirectionType(train.getDirectionType());
		trainDTO.setReseau(train.getReseau());
		trainDTO.setStatut(train.getStatut());
		trainDTO.setDirection(ArretMapper.arretDTOMapper(train.getDirection()));
		for (Arret arret : ArretMapper.arretAllDTOMapper(train.getListeArrets())) {
			trainDTO.addArret(arret);
		}
		for (Passager passager : PassagerMapper.passagerAllDTOMapper(train.getListePassagers())) {
			trainDTO.addPassager(passager);
		}

		trainDTO.setReelArriveeTemps(
				LocalDateTime.ofInstant(train.getReelArriveeTemps().toInstant(), ZoneId.systemDefault()));
		trainDTO.setReelDepartTemps(
				LocalDateTime.ofInstant(train.getReelDepartTemps().toInstant(), ZoneId.systemDefault()));
		trainDTO.setBaseDepartTemps(
				LocalDateTime.ofInstant(train.getBaseDepartTemps().toInstant(), ZoneId.systemDefault()));
		trainDTO.setBaseArriveeTemps(
				LocalDateTime.ofInstant(train.getBaseArriveeTemps().toInstant(), ZoneId.systemDefault()));

		return trainDTO;
	}

}