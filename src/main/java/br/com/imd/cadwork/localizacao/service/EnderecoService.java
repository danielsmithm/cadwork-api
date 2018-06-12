package br.com.imd.cadwork.localizacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.localizacao.dao.EnderecoDAO;
import br.com.imd.cadwork.core.localizacao.domain.Endereco;
import br.com.imd.cadwork.core.service.GenericService;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.core.service.exception.ResourceConflictException;
/**
 * Service para objetos da classe Endereco
 * @author Welligton Miguel
 *
 */

@Component
public class EnderecoService extends GenericService<Endereco> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Endereco> listar() throws GenericServiceException {
		return super.listar();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void salvar(Endereco endereco, BindingResult resultado) throws GenericServiceException {
		super.salvar(endereco, resultado);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Endereco> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}
	/**
	 * {@inheritDoc}
	 */
	@Autowired
	public void setDao(GenericDAO<Endereco> dao) {
		super.dao = dao;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void verificaExistencia(Endereco endereco) throws GenericServiceException {
		if (((EnderecoDAO) dao).
				findEnderecoByLatitudeAndLongitude(
													endereco.getLatitude(),
													endereco.getLongitude()
																			).isPresent()){
			throw new ResourceConflictException();
		}
	}

}
