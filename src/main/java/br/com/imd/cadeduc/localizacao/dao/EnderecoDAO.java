package br.com.imd.cadeduc.localizacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imd.cadeduc.localizacao.domain.Endereco;

public interface EnderecoDAO extends JpaRepository<Endereco, Long>
{

}
