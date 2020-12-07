package fr.pantheonsorbonne.ufr27.miage.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ObjectFactory;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.InfoGare;

public class InfoGareMapper {
	
	public static InfoGare infoGareDTOMapper(fr.pantheonsorbonne.ufr27.miage.jpa.InfoGare infoGare) {
		return new ObjectFactory().createInfoGare();
	}

	public static List<InfoGare> infoGareAllDTOMapper(List<fr.pantheonsorbonne.ufr27.miage.jpa.InfoGare> listeInfoGares) {
		List<InfoGare> ListeInfoGares = new ArrayList<InfoGare>();
		for (fr.pantheonsorbonne.ufr27.miage.jpa.InfoGare infoGare : listeInfoGares) {
			ListeInfoGares.add(infoGareDTOMapper(infoGare));
		}
		return ListeInfoGares;
	}

}