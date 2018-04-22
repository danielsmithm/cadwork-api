package br.com.imd.cadeduc.ensino.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.imd.cadeduc.core.service.exception.GenericServiceException;
import br.com.imd.cadeduc.ensino.domain.Serie;
import br.com.imd.cadeduc.ensino.service.SerieService;
import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/series", produces = "application/json")
@Api(tags = "Séries", value = "onlinestore", description = "Operações pertinentes a séries")
public class SerieResources {

	@Autowired
	SerieService serieService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Serie>> listar() throws GenericServiceException {

		return new ResponseEntity<>(serieService.listar(), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@Valid @RequestBody Serie serie, BindingResult resultado) throws GenericServiceException {
		serieService.salvar(serie, resultado);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(serie.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Optional<Serie>> buscar(@PathVariable("id") Long id)
			throws GenericServiceException {
		return new ResponseEntity<>(serieService.buscar(id), HttpStatus.OK);
	}
}
