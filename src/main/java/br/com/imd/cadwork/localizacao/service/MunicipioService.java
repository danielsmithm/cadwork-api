package br.com.imd.cadwork.localizacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.service.GenericService;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.core.service.exception.ResourceConflictException;
import br.com.imd.cadwork.localizacao.dao.MunicipioDAO;
import br.com.imd.cadwork.localizacao.domain.Municipio;

@Component
public class MunicipioService extends GenericService<Municipio> {

	@Override
	public List<Municipio> listar() throws GenericServiceException {
		return super.listar();
	}

	@Override
	public void salvar(Municipio municipio, BindingResult resultado) throws GenericServiceException {
		super.salvar(municipio, resultado);
	}

	@Override
	public Optional<Municipio> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}

	@Autowired
	public void setDao(GenericDAO<Municipio> dao) {
		super.dao = dao;
	}

	@Override
	protected void verificaExistencia(Municipio municipio) throws GenericServiceException {
		Optional<Municipio> municipioCadastrado = ((MunicipioDAO) dao)
				.findTop1MunicipioByNomeAndEstado(municipio.getNome(), municipio.getEstado().name());
		
		if(municipio.getId()!=0 || municipioCadastrado.isPresent()) {
			throw new ResourceConflictException();
		}

	}

}
