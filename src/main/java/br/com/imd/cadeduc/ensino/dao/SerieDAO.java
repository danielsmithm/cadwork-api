package br.com.imd.cadeduc.ensino.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imd.cadeduc.ensino.domain.Serie;

@Repository
public interface SerieDAO extends JpaRepository<Serie, Long> {

}
