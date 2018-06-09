package br.com.imd.cadwork.core.dao;


/**
 * Classe de excessões padrões
 * @author Welligton Miguel
 *
 */
public class GenericDomainException extends Exception {

	private static final long serialVersionUID = 1L;
	/**
	 * Construtor da classe
	 * @param message String - mensagem para repassar para Exception
	 */
	public GenericDomainException(String message) {
		super(message);
	}
}
