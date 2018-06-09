package br.com.imd.cadwork.core.service.exception;

/**
 * Exceção para resource não encontrado
 * @author Welligton Miguel
 *
 */
public class ResourceNotFoundException extends GenericServiceException {

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor
	 */
	public ResourceNotFoundException() {
		super("Recurso não encontrado.");
	}
	/**
	 * Construtor
	 * @param message String - mensagem da exceção
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
