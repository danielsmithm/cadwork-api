package br.com.imd.cadwork.localizacao.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.localizacao.domain.Municipio;

@Repository
public interface MunicipioDAO extends GenericDAO<Municipio> {

	@Query(value="SELECT * FROM localizacao.municipio m WHERE m.nome = :nome and m.estado = :#{#estado} LIMIT 1", nativeQuery = true)
	Optional<Municipio> findTop1MunicipioByNomeAndEstado(@Param("nome")String nome, @Param("estado") String estado);

}
