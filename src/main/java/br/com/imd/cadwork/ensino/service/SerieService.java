package br.com.imd.cadwork.ensino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.service.GenericService;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.core.service.exception.ResourceConflictException;
import br.com.imd.cadwork.ensino.dao.SerieDAO;
import br.com.imd.cadwork.ensino.domain.Serie;

@Component
public class SerieService extends GenericService<Serie> {

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

	
	@Autowired		
	public void setDao(GenericDAO<Serie> dao) {
		super.dao = dao;	
	}
	
	@Override
	protected void verificaExistencia(Serie serie) throws GenericServiceException {
		Optional<Serie> serieCadastrada = ((SerieDAO) dao).findSerieByNome(serie.getNome());
 		if(serie.getId()!=0 || serieCadastrada.isPresent()) {
 			throw new ResourceConflictException();
 		}
	}
}
