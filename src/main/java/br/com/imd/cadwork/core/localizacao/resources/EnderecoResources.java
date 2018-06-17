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

import br.com.imd.cadwork.core.localizacao.domain.Endereco;
import br.com.imd.cadwork.core.localizacao.service.EnderecoService;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import io.swagger.annotations.Api;

/**
 * Classe que faz o controle dos endpoints da API com os dados de enderecos
 * @author Welligton Miguel
 *
 */
@RestController
@RequestMapping(value = "/enderecos", produces = "application/json")
@Api(tags = "Enderecos", description = "Operações pertinentes a endereços")
public class EnderecoResources {

	@Autowired
	EnderecoService enderecoService;
	/**
	 * Retorna todos os enderecos da API
	 * @return List<{@link br.com.imd.cadwork.core.localizacao.domain.Endereco}> - todos os endereços da API
	 * @throws GenericServiceException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Endereco> listar() throws GenericServiceException {
		return enderecoService.listar();

	}
	/**
	 * Função para adicionar um endereco na API 
	 * @param municipio Endereco - endereco para ser adicionado na API 
	 * @param resultado BindingResult
	 * @return ResponseEntity<{@link java.lang.String}>
	 * @throws GenericServiceException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@Valid @RequestBody Endereco endereco, BindingResult resultado) throws GenericServiceException {

		enderecoService.salvar(endereco, resultado);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
	/**
	 * Retorna endereco associado a um determinado id
	 * @param id Long - id para retornar endereco associado
	 * @return Optional<{@link br.com.imd.cadwork.core.localizacao.domain.Endereco}> - caso o id seja válido retorna um endereco
	 * @throws GenericServiceException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Endereco> buscar(@PathVariable("id") Long id) throws GenericServiceException {
		return enderecoService.buscar(id);
	}
}
