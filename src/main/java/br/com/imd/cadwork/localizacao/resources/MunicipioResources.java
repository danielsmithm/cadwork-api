package br.com.imd.cadwork.localizacao.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.localizacao.domain.Municipio;
import br.com.imd.cadwork.localizacao.service.MunicipioService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/municipios", produces = "application/json")
@Api(tags = "Municípios", value = "onlinestore", description = "Operações pertinentes a municípios")
public class MunicipioResources {

	@Autowired
	MunicipioService municipioService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Municipio> listar() throws GenericServiceException {
		return municipioService.listar();

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@Valid @RequestBody Municipio municipio, BindingResult resultado) throws GenericServiceException {
		municipioService.salvar(municipio, resultado);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(municipio.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Municipio> buscar(@PathVariable("id") Long id) throws GenericServiceException {
		return municipioService.buscar(id);
	}
}
