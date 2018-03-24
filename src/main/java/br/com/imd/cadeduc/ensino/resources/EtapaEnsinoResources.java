package br.com.imd.cadeduc.ensino.resources;

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

import br.com.imd.cadeduc.ensino.dao.EtapaEnsinoDAO;
import br.com.imd.cadeduc.ensino.domain.EtapaEnsino;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/etapasEnsino", produces = "application/json")
@Api(tags = "Etapas de Ensino", description = "Operações pertinentes a etapas de ensino")
public class EtapaEnsinoResources {

	@Autowired
	EtapaEnsinoDAO etapaEnsinoDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<EtapaEnsino> listar() {
		return etapaEnsinoDao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody EtapaEnsino etapaEnsino) {
		etapaEnsinoDao.save(etapaEnsino);
		return new ResponseEntity<String>(
				new Gson().toJson("Etapa de Ensino cadastrada com sucesso!"), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<EtapaEnsino> buscar(@PathVariable("id") Long id) {
		return etapaEnsinoDao.findById(id);
	}
}
