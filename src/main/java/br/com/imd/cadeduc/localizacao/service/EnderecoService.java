package br.com.imd.cadeduc.localizacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import br.com.imd.cadeduc.dao.GenericDAO;
import br.com.imd.cadeduc.localizacao.domain.Endereco;
import br.com.imd.cadeduc.service.GenericService;
import br.com.imd.cadeduc.service.exception.GenericServiceException;

@Component
public class EnderecoService extends GenericService<Endereco> {

	@Autowired
	public void setDao(GenericDAO<Endereco> dao) {
		super.setDao(dao);
	}

	@Override
	public List<Endereco> listar() throws GenericServiceException {
		return super.listar();
	}

	@Override
	public void salvar(Endereco endereco, BindingResult resultado) throws GenericServiceException {
		super.salvar(endereco, resultado);
	}

	@Override
	public Optional<Endereco> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}
}
