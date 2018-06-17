package br.com.imd.cadwork.core.localizavel.dao;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.localizacao.domain.Endereco;
import br.com.imd.cadwork.core.localizavel.model.Localizavel;

/**
 * {@inheritDoc}}
 */
@NoRepositoryBean
public interface LocalizavelDAO extends GenericDAO<Localizavel> {

	public Optional<Localizavel> findByEndereco(@Param("endereco")Endereco endereco);

}
