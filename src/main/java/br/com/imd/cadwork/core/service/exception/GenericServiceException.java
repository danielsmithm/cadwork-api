package br.com.imd.cadwork.core.service.exception;

/**
 * Exceção para services
 * @author Welligton Miguel
 *
 */
public class GenericServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * Construtor
	 * @param message String - mensagem de exceção
	 */
	public GenericServiceException(String message) {
		super(message);
	}

}
