package br.com.imd.cadeduc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.BindingResult;

import br.com.imd.cadeduc.service.exception.GerericServiceException;

public interface GenericService<T> {

	public List<T> listar() throws GerericServiceException;

	public void salvar(T t, BindingResult br) throws GerericServiceException;

	public Optional<T> buscar(Long id, BindingResult br) throws GerericServiceException;
}
