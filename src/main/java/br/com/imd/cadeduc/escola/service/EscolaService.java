package br.com.imd.cadeduc.escola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import br.com.imd.cadeduc.escola.dao.EscolaDAO;
import br.com.imd.cadeduc.escola.domain.Escola;
import br.com.imd.cadeduc.service.GenericService;
import br.com.imd.cadeduc.service.exception.GenericServiceException;

@Component
public class EscolaService extends GenericService<Escola> {

	@Autowired
	public void setDao(EscolaDAO dao) {
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
	public Optional<Escola> buscar(Long id, BindingResult resultado) throws GenericServiceException {
		return super.buscar(id, resultado);
	}

}
