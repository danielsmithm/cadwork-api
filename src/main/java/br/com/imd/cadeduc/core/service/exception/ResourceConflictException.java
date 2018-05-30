package br.com.imd.cadeduc.core.service.exception;

public class ResourceConflictException extends GenericServiceException {

	private static final long serialVersionUID = 1L;

	public ResourceConflictException() {
		super("Recurso Já existente");

	}

	public ResourceConflictException(String message) {
		super(message);

	}

}
