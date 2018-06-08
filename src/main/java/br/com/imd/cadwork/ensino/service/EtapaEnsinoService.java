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
import br.com.imd.cadwork.ensino.dao.EtapaEnsinoDAO;
import br.com.imd.cadwork.ensino.domain.EtapaEnsino;

@Component
public class EtapaEnsinoService extends GenericService<EtapaEnsino> {

	@Override
	public List<EtapaEnsino> listar() throws GenericServiceException {
		return super.listar();
	}

	@Override
	public void salvar(EtapaEnsino etapaEnsino, BindingResult resultado) throws GenericServiceException {
		super.salvar(etapaEnsino, resultado);
	}

	@Override
	public Optional<EtapaEnsino> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}

	@Autowired
	public void setDao(GenericDAO<EtapaEnsino> dao) {
		super.dao = dao;
	}

	@Override
	protected void verificaExistencia(EtapaEnsino etapaEnsino) throws GenericServiceException {
		Optional<EtapaEnsino> etapaCadastrada = ((EtapaEnsinoDAO) dao).findEtapaEnsinoByNome(etapaEnsino.getNome());
		if (etapaEnsino.getId() != 0 || etapaCadastrada.isPresent()) {
			throw new ResourceConflictException();
		}
	}
}
