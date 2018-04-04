package br.com.imd.cadeduc.ensino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.imd.cadeduc.domain.exception.ResourceEmptyException;
import br.com.imd.cadeduc.ensino.dao.SerieDAO;
import br.com.imd.cadeduc.ensino.domain.Serie;
import br.com.imd.cadeduc.service.GenericService;
import br.com.imd.cadeduc.service.exception.GerericServiceException;
import br.com.imd.cadeduc.service.exception.ResourceNotFoundException;
import br.com.imd.cadeduc.util.ValidatorUtil;

@Service
public class SerieService implements GenericService<Serie> {

	@Autowired
	SerieDAO serieDao;

	@Override
	public List<Serie> listar() throws GerericServiceException {
		List<Serie> series = serieDao.findAll();

		if (series.isEmpty()) {
			throw new ResourceNotFoundException();
		}

		return series;
	}

	@Override
	public void salvar(Serie serie, BindingResult resultado) throws GerericServiceException {

		if (resultado.hasErrors()) {
			throw new ResourceEmptyException(ValidatorUtil.gerarErrorsInJson(resultado.getAllErrors()));
		}
		try {
			serieDao.save(serie);


		} catch (Exception e) {
			throw new ResourceEmptyException(e.getMessage());
		}

	}

	@Override
	public Optional<Serie> buscar(Long id, BindingResult resultado) throws GerericServiceException {

		Optional<Serie> serie = serieDao.findById(id);

		if (!serie.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return serie;
	}

}
