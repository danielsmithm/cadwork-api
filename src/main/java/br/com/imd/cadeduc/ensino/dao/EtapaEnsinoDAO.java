package br.com.imd.cadeduc.ensino.dao;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.imd.cadeduc.core.dao.GenericDAO;
import br.com.imd.cadeduc.ensino.domain.EtapaEnsino;

@Repository
public interface EtapaEnsinoDAO extends GenericDAO<EtapaEnsino> {

	public Optional<EtapaEnsino> findEtapaEnsinoByNome(@Param("nome") String nome);
}
