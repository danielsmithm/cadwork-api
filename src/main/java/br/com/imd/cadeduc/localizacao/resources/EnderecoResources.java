package br.com.imd.cadeduc.localizacao.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.imd.cadeduc.localizacao.dao.EnderecoDAO;
import br.com.imd.cadeduc.localizacao.domain.Endereco;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/enderecos")
@Api(tags = "Endereços", description = "Operações pertinentes a endereços")
public class EnderecoResources {

	@Autowired
	EnderecoDAO enderecoDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Endereco> listar() {
		return enderecoDao.findAll();

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Endereco endereco) {
		enderecoDao.save(endereco);
		return new ResponseEntity<String>(
				new Gson().toJson("Endereço cadastrado com sucesso!"), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Endereco> buscar(@PathVariable("id") Long id) {
		return enderecoDao.findById(id);
	}

}
