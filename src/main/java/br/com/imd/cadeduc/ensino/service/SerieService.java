package br.com.imd.cadeduc.ensino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import br.com.imd.cadeduc.core.dao.GenericDAO;
import br.com.imd.cadeduc.core.service.GenericService;
import br.com.imd.cadeduc.core.service.exception.GenericServiceException;
import br.com.imd.cadeduc.ensino.domain.Serie;

@Component
public class SerieService extends GenericService<Serie> {

	@Autowired		
	public void setDao(GenericDAO<Serie> dao) {
		super.setDao(dao);	
	}
	
	@Override
	public List<Serie> listar() throws GenericServiceException {
		return super.listar();
	}

	@Override
	public void salvar(Serie serie, BindingResult resultado) throws GenericServiceException {
		super.salvar(serie, resultado);
	}

	@Override
	public Optional<Serie> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}
}
