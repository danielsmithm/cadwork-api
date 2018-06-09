package br.com.imd.cadwork.core.localizacao.resources;

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

import br.com.imd.cadwork.core.localizacao.domain.Municipio;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.localizacao.service.MunicipioService;
import io.swagger.annotations.Api;
/**
 * Classe que faz o controle dos endpoints da API com os dados de municipios
 * @author Welligton Miguel
 *
 */
@RestController
@RequestMapping(value = "/municipios", produces = "application/json")
@Api(tags = "Municípios", value = "onlinestore", description = "Operações pertinentes a municípios")
public class MunicipioResources {

	@Autowired
	MunicipioService municipioService;
	/**
	 * Retorna todos os municipios da API
	 * @return List<Municipio> - todos os municipios da API
	 * @throws GenericServiceException
	 */
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Municipio> listar() throws GenericServiceException {
		return municipioService.listar();

	}
	/**
	 * Função para adicionar municipio na API 
	 * @param municipio Municipio - municipio para ser adicionado na API 
	 * @param resultado BindingResult
	 * @return ResponseEntity<String>
	 * @throws GenericServiceException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@Valid @RequestBody Municipio municipio, BindingResult resultado) throws GenericServiceException {
		municipioService.salvar(municipio, resultado);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(municipio.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}
	/**
	 * Retorna municipio associado a um determinado id
	 * @param id Long - id para retornar municipio associado
	 * @return Optional<Municipio> - caso o id seja válido retorna um muninipio
	 * @throws GenericServiceException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Municipio> buscar(@PathVariable("id") Long id) throws GenericServiceException {
		return municipioService.buscar(id);
	}
}
