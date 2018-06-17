package br.com.imd.cadwork.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.imd.cadwork.core.localizavel.model.Localizavel;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.util.exception.ConvertLocalizavelException;
import se.walkercrou.places.Param;

/**
 * {@inheritDoc}}
 */
@Service
public abstract class LocalizavelService extends GenericService<Localizavel> {

	/**
	 * Função que retorna uma lista de localizáveis cadastrados no google baseado na latitude e longitude
	 * @param lat - Latitude do localizável
	 * @param lng - Longitude do localizável
	 * @param keyword - Plavra chave a ser pesquisada
	 * @return - Lista contendo os localizáveis disponíveis
	 * @throws GenericServiceException
	 * @throws ConvertLocalizavelException
	 */
	protected List<Map<String, Object>> buscarLocalizaveisProximos(Double lat, Double lng, String keyword) throws GenericServiceException, ConvertLocalizavelException  {
		Param param = new Param("keyword");
		param.value(keyword);
		
		return googleService.getLocalizaveisByLatLng(lat, lng, param);
	}
}
