package br.com.imd.cadwork.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.core.service.exception.ResourceEmptyException;
import br.com.imd.cadwork.core.service.exception.ResourceNotFoundException;
import br.com.imd.cadwork.util.ValidatorUtil;

@Service
public abstract class GenericService<T> {

	protected GenericDAO<T> dao;

	protected List<T> listar() throws GenericServiceException {
		List<T> entidades = dao.findAll();
		
		entidades.stream()
		.findAny()
		.orElseThrow(ResourceNotFoundException::new);
		
		return entidades;
	}

	protected void salvar(T t, BindingResult resultado) throws GenericServiceException {

		if (resultado.hasErrors()) {
			throw new ResourceEmptyException(ValidatorUtil.gerarErrorsInJson(resultado.getAllErrors()));
		}
		verificaExistencia(t);
		
		try {

			dao.save(t);

		} catch (Exception e) {
			throw new GenericServiceException(e.getMessage());
		}

	}

	protected Optional<T> buscar(Long id) throws GenericServiceException {
		T entidade = dao.findById(id).orElseThrow(ResourceNotFoundException::new);
		
		return Optional.of(entidade);
	}

	protected abstract void setDao(GenericDAO<T> dao);
	protected abstract void verificaExistencia(T t) throws GenericServiceException;

}
