package br.com.imd.cadwork.core.service.exception;

/**
 * Exceção para resource de conflito
 * @author Welligton Miguel
 *
 */
public class ResourceConflictException extends GenericServiceException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor
	 */
	public ResourceConflictException() {
		super("Recurso Já existente");

	}
	/**
	 * Constutor
	 * @param message String - mensagem da exceção
	 */
	public ResourceConflictException(String message) {
		super(message);

	}

}
