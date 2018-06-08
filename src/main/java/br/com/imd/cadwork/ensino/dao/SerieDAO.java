package br.com.imd.cadwork.ensino.dao;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.ensino.domain.Serie;

@Repository
public interface SerieDAO extends GenericDAO<Serie> {

	Optional<Serie> findSerieByNome(@Param("nome") String nome);
}
