package br.com.imd.cadeduc.localizacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imd.cadeduc.localizacao.domain.Municipio;

public interface MunicipioDAO extends JpaRepository<Municipio, Long> 
{

}
