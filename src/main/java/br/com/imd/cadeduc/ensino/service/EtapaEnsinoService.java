package br.com.imd.cadeduc.ensino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import br.com.imd.cadeduc.core.dao.GenericDAO;
import br.com.imd.cadeduc.core.service.GenericService;
import br.com.imd.cadeduc.core.service.exception.GenericServiceException;
import br.com.imd.cadeduc.core.service.exception.ResourceConflictException;
import br.com.imd.cadeduc.ensino.dao.EtapaEnsinoDAO;
import br.com.imd.cadeduc.ensino.domain.EtapaEnsino;

@Component
public class EtapaEnsinoService extends GenericService<EtapaEnsino> {

	@Autowired
	public void setDao(GenericDAO<EtapaEnsino> dao) {
		super.setDao(dao);
	}

	@Override
	public List<EtapaEnsino> listar() throws GenericServiceException {
		return super.listar();
	}

	@Override
	public void salvar(EtapaEnsino etapaEnsino, BindingResult resultado) throws GenericServiceException {
		Optional<EtapaEnsino> etapaCadastrada = ((EtapaEnsinoDAO) dao).findEtapaEnsinoByNome(etapaEnsino.getNome());
		if(etapaEnsino.getId()!=0 || etapaCadastrada.isPresent()) {
			throw new ResourceConflictException();
		}
		super.salvar(etapaEnsino, resultado);
	}

	@Override
	public Optional<EtapaEnsino> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}
}
