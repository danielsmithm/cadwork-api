package br.com.imd.cadwork.localizacao.domain;

import io.swagger.annotations.ApiModel;

/**
 * 
 * Enumeração dos possíveis tipos de localização
 * 
 * @author Miguel
 * @version 0.2
 *
 */

@ApiModel
public enum TipoLocalizacaoEnum {
	
	/**
	 * <strong>Rural</strong> - 1
	 * <strong>Urbana</strong> - 2
	 */
	
	Rural,
	Urbana
	
}
