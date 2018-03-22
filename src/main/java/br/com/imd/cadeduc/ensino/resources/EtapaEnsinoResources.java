package br.com.imd.cadeduc.ensino.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.cadeduc.ensino.dao.EtapaEnsinoDAO;
import br.com.imd.cadeduc.ensino.domain.EtapaEnsino;

@RestController
@RequestMapping(value = "/etapasEnsino", produces = "application/json")
public class EtapaEnsinoResources {

	@Autowired
	EtapaEnsinoDAO etapaEnsinoDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<EtapaEnsino> listar() {
		return etapaEnsinoDao.findAll();

	}

	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody EtapaEnsino etapaEnsino) {
		etapaEnsinoDao.save(etapaEnsino);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<EtapaEnsino> buscar(@PathVariable("id") Long id) {
		return etapaEnsinoDao.findById(id);
	}
}
