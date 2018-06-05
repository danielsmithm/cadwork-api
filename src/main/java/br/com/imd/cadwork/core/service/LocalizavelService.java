package br.com.imd.cadwork.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.BindingResult;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.model.Localizavel;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;

/**
 * Classe abstrata para o service do Localizavel
 * @author Igor Barbosa Nogueira
 * @version 0.1
 */

public abstract class LocalizavelService extends GenericService<Localizavel> {

	@Override
	public List<Localizavel> listar() throws GenericServiceException {
		return super.listar();
	}

	@Override
	public void salvar(Localizavel localizavel, BindingResult resultado) throws GenericServiceException {
		super.salvar(localizavel, resultado);
	}

	@Override
	public Optional<Localizavel> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}

	@Override
	public abstract void setDao(GenericDAO<Localizavel> dao);

	@Override
	public abstract void verificaExistencia(Localizavel localizavel) throws GenericServiceException;

}
