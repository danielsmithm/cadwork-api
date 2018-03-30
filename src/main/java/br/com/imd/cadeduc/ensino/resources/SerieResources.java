package br.com.imd.cadeduc.ensino.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.cadeduc.ensino.dao.SerieDAO;
import br.com.imd.cadeduc.ensino.domain.Serie;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/series")
@Api(tags = "Séries", value = "onlinestore", description = "Operações pertinentes a séries")
public class SerieResources {

	@Autowired
	SerieDAO serieDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Serie> listar() {
		return serieDao.findAll();

	}

	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Serie serie) {
		serieDao.save(serie);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Serie> buscar(@PathVariable("id") Long id) {
		return serieDao.findById(id);
	}
}
