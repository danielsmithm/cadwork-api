package br.com.imd.cadwork.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.com.imd.cadwork.util.exception.ConvertLocalizavelException;
import se.walkercrou.places.Place;

public class GoogleValidator {

	public static List<Map<String,Object>> convertPlaceInMapLocalizavel(List<Place> places) throws ConvertLocalizavelException {
		
		List<Map<String,Object>> listMapLocalizavel = new LinkedList<>();
		try {
			places.stream().forEach(place -> listMapLocalizavel.add(getEnderecoInPlace(place)));			
		}catch (Exception e) {
			throw new ConvertLocalizavelException();
		}

		return listMapLocalizavel;
	}
	
	private static Map<String,Object> getEnderecoInPlace(Place place) {
		Map<String,Object> mapLocalizavel = new HashMap<>();
		mapLocalizavel.put("nome",      place.getName());
		mapLocalizavel.put("latitude",  place.getLatitude());
		mapLocalizavel.put("longitude", place.getLongitude());
		mapLocalizavel.put("logradouro",place.getVicinity());
		
		return mapLocalizavel;
	}

}
