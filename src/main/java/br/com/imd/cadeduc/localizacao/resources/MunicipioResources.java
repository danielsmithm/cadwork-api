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

import br.com.imd.cadeduc.localizacao.dao.MunicipioDAO;
import br.com.imd.cadeduc.localizacao.domain.Municipio;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/municipios")
@Api(tags = "Municípios", value = "onlinestore", description = "Operações pertinentes a municípios")
public class MunicipioResources {
	@Autowired
	MunicipioDAO municipioDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Municipio> listar() {
		return municipioDao.findAll();

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Municipio municipio) {
		municipioDao.save(municipio);
		return new ResponseEntity<String>(
				new Gson().toJson("Município cadastrado com sucesso!"), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Municipio> buscar(@PathVariable("id") Long id) {
		return municipioDao.findById(id);
	}
}
