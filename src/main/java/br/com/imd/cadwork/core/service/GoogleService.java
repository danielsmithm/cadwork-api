package br.com.imd.cadwork.core.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.util.GoogleValidator;
import br.com.imd.cadwork.util.exception.ConvertLocalizavelException;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Param;
import se.walkercrou.places.Place;

@Service
public class GoogleService {

	public static final String KEY = "AIzaSyD5SoFyhcb2eNCBW4PFwpt56BwMXWGDbHc";
	public static final int RAIO_BUSCA = 500;
	public static final int LIMITE_BUSCA = 20;
	public static final int BUSCA_INDIVIDUAL = 1;
	
	public static final String ESCOLA = "escola";
	public static final String PARADA = "bus";
	
	private GooglePlaces cliente;

	public GoogleService() {
		cliente = new GooglePlaces(KEY);
	}

	/**
	 * Busca especificamente o localizavel pertencente a latitude e longitude
	 * @param lat
	 * @param lng
	 * @param extraParams
	 * @return
	 * @throws GenericServiceException
	 * @throws ConvertLocalizavelException
	 */
	public List<Map<String, Object>> getLocalizavelByLatLng(Double lat, Double lng,Param... extraParams) 
			throws GenericServiceException, ConvertLocalizavelException {

		return getLocalizaveisProximos(lat,lng,RAIO_BUSCA,BUSCA_INDIVIDUAL,extraParams);
	}	
	
	/**
	 * Retorna uma lista com 20 localizáveis mais próximos no raio de 50.000 metros
	 * @param lat
	 * @param lng
	 * @param extraParams
	 * @return
	 * @throws GenericServiceException
	 * @throws ConvertLocalizavelException
	 */
	public List<Map<String, Object>> getLocalizaveisByLatLng(Double lat, Double lng,Param... extraParams) 
			throws GenericServiceException, ConvertLocalizavelException {

		return getLocalizaveisProximos(lat,lng,RAIO_BUSCA,LIMITE_BUSCA,extraParams);
	}
	
	
	/**
	 * Core da consulta por latitude e longitude, invoca o service da google 
	 * 		informando os parâmetros necessários 
	 * @param lat
	 * @param lng
	 * @param raio
	 * @param limite
	 * @param extraParams
	 * @return
	 * @throws GenericServiceException
	 * @throws ConvertLocalizavelException
	 */
	private List<Map<String, Object>> getLocalizaveisProximos(Double lat, Double lng, int raio, int limite,
			Param... extraParams) throws GenericServiceException, ConvertLocalizavelException {
		List<Place> places = new LinkedList<>();
	
		places = cliente.getNearbyPlaces(lat,lng,raio,limite,extraParams);
		
		return GoogleValidator.convertPlaceInMapLocalizavel(places);	
	}
	
	
	public GooglePlaces getCliente() {
		return cliente;
	}

	public void setCliente(GooglePlaces cliente) {
		this.cliente = cliente;
	}

	public boolean validaExistencia(Double lat, Double lng,String tipoInstituicao) {
		Param param = new Param("keyword");
		param.value(tipoInstituicao);
		try {

			return cliente.getNearbyPlacesRankedByDistance(lat, 
														   lng, 
														   BUSCA_INDIVIDUAL, 
														   param
														   )
			.stream()
			.findFirst()
			.isPresent();

		}catch (Exception e) {
			return false;
		}
	}
}
