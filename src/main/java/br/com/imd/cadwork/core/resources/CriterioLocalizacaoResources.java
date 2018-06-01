package br.com.imd.cadwork.core.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.model.CriterioLocalizacao;
import br.com.imd.cadwork.core.service.CriterioLocalizacaoService;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;

public abstract class CriterioLocalizacaoResources {

	protected CriterioLocalizacaoService criterioLocalizacaoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<CriterioLocalizacao> buscar(@PathVariable("id") Long id) throws GenericServiceException {
		return criterioLocalizacaoService.buscar(id);
	}
	
	public abstract List<CriterioLocalizacao> listar();
	public abstract ResponseEntity<String> salvar(@Valid @RequestBody CriterioLocalizacao criterioLocalizacao, BindingResult resultado);
	public abstract void setDao(GenericDAO<CriterioLocalizacao> dao);//TEM QUE SER AUTOWIRED
	
}
