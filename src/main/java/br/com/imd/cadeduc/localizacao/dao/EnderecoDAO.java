package br.com.imd.cadeduc.localizacao.dao;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.imd.cadeduc.core.dao.GenericDAO;
import br.com.imd.cadeduc.localizacao.domain.Endereco;

@Repository
public interface EnderecoDAO extends GenericDAO<Endereco> {

	public Optional<Endereco> findEnderecoByLatitudeAndLongitude(@Param("latitude") double latitude,
																 @Param("longitude") double longitude);
}
