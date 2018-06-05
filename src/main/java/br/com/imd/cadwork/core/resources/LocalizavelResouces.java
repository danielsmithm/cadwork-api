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
import br.com.imd.cadwork.core.model.Localizavel;
import br.com.imd.cadwork.core.service.LocalizavelService;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;

/**
 * Resource abstrato do Localizavel
 * @author igor
 *
 */

public abstract class LocalizavelResouces {

	protected LocalizavelService localizavelService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Localizavel> buscar(@PathVariable("id") Long id) throws GenericServiceException {
		return localizavelService.buscar(id);
	}
	
	public abstract List<Localizavel> listar();
	public abstract ResponseEntity<String> salvar(@Valid @RequestBody Localizavel localizavel, BindingResult resultado);
	public abstract void setDao(GenericDAO<Localizavel> dao);//TEM QUE SER AUTOWIRED
}
