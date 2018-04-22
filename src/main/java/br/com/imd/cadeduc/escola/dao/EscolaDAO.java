package br.com.imd.cadeduc.escola.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.imd.cadeduc.core.dao.GenericDAO;
import br.com.imd.cadeduc.escola.domain.Escola;

@Repository
public interface EscolaDAO extends GenericDAO<Escola> {

	@Query("SELECT e FROM Escola e WHERE e.endereco.id = :idEndereco")
	public Optional<Escola> findEscolaByEndereco(@Param("idEndereco") Long idEndereco);
}
