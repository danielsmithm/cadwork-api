package br.com.imd.cadeduc.localizacao.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.cadeduc.localizacao.dao.MunicipioDAO;
import br.com.imd.cadeduc.localizacao.domain.Municipio;

@RestController
@RequestMapping(value = "/municipios")
public class MunicipioResources {
	@Autowired
	MunicipioDAO municipioDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Municipio> listar() {
		return municipioDao.findAll();

	}

	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Municipio municipio) {
		municipioDao.save(municipio);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Municipio> buscar(@PathVariable("id") Long id) {
		return municipioDao.findById(id);
	}
}
