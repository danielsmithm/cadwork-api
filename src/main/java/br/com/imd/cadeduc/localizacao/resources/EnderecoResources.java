package br.com.imd.cadeduc.localizacao.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.cadeduc.localizacao.dao.EnderecoDAO;
import br.com.imd.cadeduc.localizacao.domain.Endereco;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResources {

	@Autowired
	EnderecoDAO enderecoDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Endereco> listar() {
		return enderecoDao.findAll();

	}

	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Endereco endereco) {
		enderecoDao.save(endereco);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Endereco> buscar(@PathVariable("id") Long id) {
		return enderecoDao.findById(id);
	}

}
