package br.com.imd.cadeduc.ensino.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.imd.cadeduc.ensino.domain.Serie;
import br.com.imd.cadeduc.ensino.service.SerieService;
import br.com.imd.cadeduc.service.exception.GerericServiceException;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/series")
@Api(tags = "Séries", value = "onlinestore", description = "Operações pertinentes a séries")
public class SerieResources {

	@Autowired
	SerieService serieService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Serie>> listar() throws GerericServiceException {

		return new ResponseEntity<>(serieService.listar(), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@Valid @RequestBody Serie serie, BindingResult resultado){
		try {
			serieService.salvar(serie,resultado);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			        .buildAndExpand(serie.getId()).toUri();

			    return ResponseEntity.created(uri).build();
			
		} catch (GerericServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Optional<Serie>> buscar(@PathVariable("id") Long id, BindingResult resultado)
			throws GerericServiceException {
		return new ResponseEntity<>(serieService.buscar(id, resultado), HttpStatus.OK);
	}
}
