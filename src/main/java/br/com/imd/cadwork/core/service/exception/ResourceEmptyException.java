package br.com.imd.cadwork.core.service.exception;

/**
 * Exceção para resource vazio
 * @author Welligton Miguel
 *
 */
public class ResourceEmptyException extends GenericServiceException {

	private static final long serialVersionUID = 1L;

	/**
	 * Contrutor
	 */
	public ResourceEmptyException(String message) {
		super(message);
	}
}
