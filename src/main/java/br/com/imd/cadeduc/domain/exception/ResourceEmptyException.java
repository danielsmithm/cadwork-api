package br.com.imd.cadeduc.domain.exception;

import br.com.imd.cadeduc.service.exception.GerericServiceException;

public class ResourceEmptyException extends GerericServiceException {

	private static final long serialVersionUID = 1L;

	public ResourceEmptyException(String message) {
		super(message);
	}
}
