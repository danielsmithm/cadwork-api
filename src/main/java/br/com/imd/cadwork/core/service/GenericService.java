package br.com.imd.cadwork.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.core.service.exception.ResourceEmptyException;
import br.com.imd.cadwork.core.service.exception.ResourceNotFoundException;
import br.com.imd.cadwork.util.ValidatorUtil;

/**	
 * Service genérico para objetos do framework
 * 
 * @author Welligton Miguel
 *
 * @param <T>
 */
@Service
public abstract class GenericService<T> {

	protected GenericDAO<T> dao;
	
	@Autowired
	protected GoogleService googleService;

	/**
	 * Retorna uma lista de objetos
	 * 
	 * @return List<T> - lista de objetos
	 * @throws GenericServiceException
	 */
	protected List<T> listar() throws GenericServiceException {
		List<T> entidades = dao.findAll();

		entidades.stream().findAny().orElseThrow(ResourceNotFoundException::new);

		return entidades;
	}

	/**
	 * Procedimento para salvar um objeto
	 * 
	 * @param t
	 *            T - objeto para ser salvo
	 * @param resultado
	 *            BindingResult - resultados da operação
	 * @throws GenericServiceException
	 */
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

	/**
	 * Busca um onjeto por um id passado
	 * 
	 * @param id
	 *            Long - busca um objeto pelo id
	 * @return Optional<T> - retorna o objeto caso exista
	 * @throws GenericServiceException
	 */
	protected Optional<T> buscar(Long id) throws GenericServiceException {
		T entidade = dao.findById(id).orElseThrow(ResourceNotFoundException::new);

		return Optional.of(entidade);
	}

	/**
	 * Função abstrata que tem que ser injetada para setar o dao correto
	 * 
	 * @param dao
	 *            GenericDAO<T>
	 */
	protected abstract void setDao(GenericDAO<T> dao);

	/**
	 * Verifica a existência de um determinado objeto no BD
	 * 
	 * @param t
	 *            T - objeto passado
	 * @throws GenericServiceException
	 */
	protected abstract void verificaExistencia(T t) throws GenericServiceException;

}
