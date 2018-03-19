package br.com.imd.cadeduc.ensino.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imd.cadeduc.ensino.domain.EtapaEnsino;

@Repository
public interface EtapaEnsinoDAO extends JpaRepository<EtapaEnsino, Long> {

}
