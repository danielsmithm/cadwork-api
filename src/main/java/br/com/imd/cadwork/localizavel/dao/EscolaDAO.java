package br.com.imd.cadwork.localizavel.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.localizavel.domain.Escola;

@Repository
public interface EscolaDAO extends GenericDAO<Escola> {

	@Query("SELECT e FROM Escola e WHERE e.endereco.id = :idEndereco")
	public Optional<Escola> findEscolaByEndereco(@Param("idEndereco") Long idEndereco);
}
