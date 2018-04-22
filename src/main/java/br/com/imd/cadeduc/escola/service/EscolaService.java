package br.com.imd.cadeduc.escola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import br.com.imd.cadeduc.core.dao.GenericDAO;
import br.com.imd.cadeduc.core.service.GenericService;
import br.com.imd.cadeduc.core.service.exception.GenericServiceException;
import br.com.imd.cadeduc.escola.domain.Escola;

@Component
public class EscolaService extends GenericService<Escola> {

	@Autowired
	public void setDao(GenericDAO<Escola> dao) {
		super.setDao(dao);
	}

	@Override
	public List<Escola> listar() throws GenericServiceException {
		return super.listar();
	}

	@Override
	public void salvar(Escola escola, BindingResult resultado) throws GenericServiceException {
		super.salvar(escola, resultado);
	}

	@Override
	public Optional<Escola> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}

}
