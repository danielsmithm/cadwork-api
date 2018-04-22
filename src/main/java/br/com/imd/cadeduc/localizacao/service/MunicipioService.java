package br.com.imd.cadeduc.localizacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import br.com.imd.cadeduc.core.dao.GenericDAO;
import br.com.imd.cadeduc.core.service.GenericService;
import br.com.imd.cadeduc.core.service.exception.GenericServiceException;
import br.com.imd.cadeduc.localizacao.domain.Municipio;

@Component
public class MunicipioService extends GenericService<Municipio>{

	@Autowired		
	public void setDao(GenericDAO<Municipio> dao) {
		super.setDao(dao);	
	}
	
	@Override
	public List<Municipio> listar() throws GenericServiceException {
		return super.listar();
	}

	@Override
	public void salvar(Municipio municipio, BindingResult resultado) throws GenericServiceException {
		super.salvar(municipio, resultado);
	}

	@Override
	public Optional<Municipio> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}
}
