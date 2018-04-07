package br.com.imd.cadeduc.localizacao.resources;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.imd.cadeduc.localizacao.domain.Endereco;
import br.com.imd.cadeduc.localizacao.service.EnderecoService;
import br.com.imd.cadeduc.service.exception.GenericServiceException;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/enderecos")
@Api(tags = "Endereços", description = "Operações pertinentes a endereços")
public class EnderecoResources {

	@Autowired
	EnderecoService enderecoService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Endereco> listar() throws GenericServiceException {
		return enderecoService.listar();

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@Valid @RequestBody Endereco municipio, BindingResult resultado) {
		try {
			enderecoService.salvar(municipio, resultado);

			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(municipio.getId())
					.toUri();

			return ResponseEntity.created(uri).build();

		} catch (GenericServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Endereco> buscar(@Valid @PathVariable("id") Long id, BindingResult resultado)
			throws GenericServiceException {
		return enderecoService.buscar(id, resultado);
	}

}
