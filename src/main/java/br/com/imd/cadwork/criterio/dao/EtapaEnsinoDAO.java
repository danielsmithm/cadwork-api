package br.com.imd.cadwork.criterio.dao;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.criterio.domain.EtapaEnsino;

@Repository
public interface EtapaEnsinoDAO extends GenericDAO<EtapaEnsino> {

	public Optional<EtapaEnsino> findEtapaEnsinoByNome(@Param("nome") String nome);
}
