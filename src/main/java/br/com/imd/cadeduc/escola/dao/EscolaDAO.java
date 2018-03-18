package br.com.imd.cadeduc.escola.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imd.cadeduc.escola.domain.Escola;

@Repository
public interface EscolaDAO extends JpaRepository<Escola, Long> {

}
