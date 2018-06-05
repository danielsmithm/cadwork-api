package br.com.imd.cadwork.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.model.CriterioLocalizacao;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;

/**
 * Classe abstrata para o service do critério de localização
 * @author Igor Barbosa Nogueira
 * @version 0.1
 */

public abstract class CriterioLocalizacaoService extends GenericService<CriterioLocalizacao> {

	@Override
	public List<CriterioLocalizacao> listar() throws GenericServiceException {
		return super.listar();
	}
	
	@Override
	public void salvar(CriterioLocalizacao criterio, BindingResult resultado) throws GenericServiceException {
		super.salvar(criterio, resultado);
	}
	
	@Override
	public Optional<CriterioLocalizacao> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}
	
	@Autowired
	public void setDao(GenericDAO<CriterioLocalizacao> dao) {
		super.dao = dao;
	}
	
	@Override
	public abstract void verificaExistencia(CriterioLocalizacao criterio);
	
}
