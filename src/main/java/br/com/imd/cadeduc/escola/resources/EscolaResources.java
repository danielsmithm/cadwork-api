package br.com.imd.cadeduc.escola.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.cadeduc.escola.dao.EscolaDAO;
import br.com.imd.cadeduc.escola.domain.Escola;

@RestController
@RequestMapping(value = "/escolas")
public class EscolaResources {

	@Autowired
	EscolaDAO escolaDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Escola> listar() {
		return escolaDao.findAll();

	}

	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Escola escola) {
		escolaDao.save(escola);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Escola> buscar(@PathVariable("id") Long id) {
		return escolaDao.findById(id);
	}
}
