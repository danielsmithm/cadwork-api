package br.com.imd.cadwork.core.localizacao.dao;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.localizacao.domain.Endereco;
/**
 * Interface que herda da GeneticDAO para criar um DAO de Endereço
 * @author Welligton Miguel
 */
@Repository
public interface EnderecoDAO extends GenericDAO<Endereco> {
	/**
	 * Função para buscar endereço através da longitude e latitude
	 * 
	 * @param latitude double - latitude do endereço
	 * @param longitude double - longitude do endereço
	 * @return Option<Endereco> - Optional de um endereço
	 */
	public Optional<Endereco> findEnderecoByLatitudeAndLongitude(@Param("latitude") double latitude,
																 @Param("longitude") double longitude);
}
