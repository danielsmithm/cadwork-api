package br.com.imd.cadeduc.escola.resources;

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

import br.com.imd.cadeduc.escola.dao.EscolaDAO;
import br.com.imd.cadeduc.escola.domain.Escola;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/escolas", produces = "application/json")
@Api(tags = "Escolas", description = "Operações pertinentes a escolas")
public class EscolaResources {

	@Autowired
	EscolaDAO escolaDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Escola> listar() {
		return escolaDao.findAll();

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Escola escola) {
		escolaDao.save(escola);
		return new ResponseEntity<String>(
				new Gson().toJson("Escola cadastrada com sucesso!"), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Escola> buscar(@PathVariable("id") Long id) {
		return escolaDao.findById(id);
	}
}
