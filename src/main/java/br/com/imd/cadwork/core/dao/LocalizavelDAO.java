package br.com.imd.cadwork.core.dao;

import org.springframework.data.repository.NoRepositoryBean;

import br.com.imd.cadwork.core.model.Localizavel;

/**
 * DAO para o tipo abstrato Localizavel
 * @author igor
 * @version 0.1
 */

@NoRepositoryBean
public interface LocalizavelDAO extends GenericDAO<Localizavel> {

}
