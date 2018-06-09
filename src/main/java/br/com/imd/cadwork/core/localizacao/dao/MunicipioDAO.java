package br.com.imd.cadwork.core.localizacao.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.localizacao.domain.Municipio;
/**
 * Interface que herda da GeneticDAO para criar um DAO de Municipio
 * @author Welligton Miguel
 */
@Repository
public interface MunicipioDAO extends GenericDAO<Municipio> {
	
	/**
	 * Retorna um único municipio para o nome e estado passados
	 * @param nome String - nome do municipio a ser pesquisado
	 * @param estado String - estado ao qual o municipio pertence
	 * @return Optional<{@link br.com.imd.cadwork.core.localizacao.domain.Municipio}> - optional de um municipio
	 */
	@Query(value="SELECT * FROM localizacao.municipio m WHERE m.nome = :nome and m.estado = :#{#estado} LIMIT 1", nativeQuery = true)
	Optional<Municipio> findTop1MunicipioByNomeAndEstado(@Param("nome")String nome, @Param("estado") String estado);

}
