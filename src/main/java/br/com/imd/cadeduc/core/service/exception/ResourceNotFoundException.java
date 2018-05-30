package br.com.imd.cadeduc.core.service.exception;

public class ResourceNotFoundException extends GenericServiceException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Recurso não encontrado.");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
