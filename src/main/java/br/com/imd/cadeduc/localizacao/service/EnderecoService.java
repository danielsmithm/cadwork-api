package br.com.imd.cadeduc.localizacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import br.com.imd.cadeduc.localizacao.dao.EnderecoDAO;
import br.com.imd.cadeduc.localizacao.domain.Endereco;
import br.com.imd.cadeduc.service.GenericService;
import br.com.imd.cadeduc.service.exception.GenericServiceException;

public class EnderecoService extends GenericService<Endereco>{

	@Autowired		
	public void setDao(EnderecoDAO dao) {
		super.setDao(dao);	
	}
	
	@Override
	public List<Endereco> listar() throws GenericServiceException {
		return super.listar();
	}

	@Override
	public void salvar(Endereco municipio, BindingResult resultado) throws GenericServiceException {
		super.salvar(municipio, resultado);
	}

	@Override
	public Optional<Endereco> buscar(Long id, BindingResult resultado) throws GenericServiceException {
		return super.buscar(id, resultado);
	}
}
