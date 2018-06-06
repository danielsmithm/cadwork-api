package br.com.imd.cadwork.core.model;

import javax.persistence.MappedSuperclass;

/**
 * Interface para criação dos critérios 
 * 
 * @author Igor Barbosa Nogueira
 * @version 0.1
 */
@MappedSuperclass
public interface CriterioLocalizacao {

	public void validarCriterio();
	
}
