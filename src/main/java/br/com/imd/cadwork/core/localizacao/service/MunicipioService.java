package br.com.imd.cadwork.core.localizacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.localizacao.dao.MunicipioDAO;
import br.com.imd.cadwork.core.localizacao.domain.Municipio;
import br.com.imd.cadwork.core.service.GenericService;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.core.service.exception.ResourceConflictException;
/**
 * Service para objetos da classe Endereco
 * @author Welligton Miguel
 *
 */
@Component
public class MunicipioService extends GenericService<Municipio> {
	/**
	 * {@inheritDoc}}
	 */
	@Override
	public List<Municipio> listar() throws GenericServiceException {
		return super.listar();
	}
	/**
	 * {@inheritDoc}}
	 */
	@Override
	public void salvar(Municipio municipio, BindingResult resultado) throws GenericServiceException {
		super.salvar(municipio, resultado);
	}
	/**
	 * {@inheritDoc}}
	 */
	@Override
	public Optional<Municipio> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}
	/**
	 * {@inheritDoc}}
	 */
	@Autowired
	public void setDao(GenericDAO<Municipio> dao) {
		super.dao = dao;
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	protected void verificaExistencia(Municipio municipio) throws GenericServiceException {
		if (((MunicipioDAO) dao).findTop1MunicipioByNomeAndEstado(	municipio.getNome(), 
																	municipio.getEstado().name()).isPresent()) {
			throw new ResourceConflictException();
		}
	}

}
