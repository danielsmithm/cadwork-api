package br.com.imd.cadeduc.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.imd.cadeduc.core.dao.GenericDAO;
import br.com.imd.cadeduc.core.service.exception.GenericServiceException;
import br.com.imd.cadeduc.core.service.exception.ResourceEmptyException;
import br.com.imd.cadeduc.core.service.exception.ResourceNotFoundException;
import br.com.imd.cadeduc.util.ValidatorUtil;

@Service
public abstract class GenericService<T> {

	protected GenericDAO<T> dao;

	public void setDao(GenericDAO<T> dao) {
		this.dao = dao;
	}

	protected List<T> listar() throws GenericServiceException {
		List<T> entidades = dao.findAll();

		if (entidades.isEmpty()) {
			throw new ResourceNotFoundException();
		}

		return entidades;
	}

	protected void salvar(T t, BindingResult resultado) throws GenericServiceException {

		if (resultado.hasErrors()) {
			throw new ResourceEmptyException(ValidatorUtil.gerarErrorsInJson(resultado.getAllErrors()));
		}
		try {
			dao.save(t);

		} catch (Exception e) {
			throw new GenericServiceException(e.getMessage());
		}

	}

	protected Optional<T> buscar(Long id) throws GenericServiceException {

		Optional<T> entidade = dao.findById(id);

		if (!entidade.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return entidade;
	}

}
