package br.com.imd.cadwork.util.exception;

public class ConvertLocalizavelException extends Exception{

	private static final long serialVersionUID = 1L;

	public ConvertLocalizavelException() {
		super("Erro ao converter Localizável");
	}
	
	/**
	 * Construtor
	 * @param message String - mensagem da exceção
	 */
	public ConvertLocalizavelException(String message) {
		super(message);
	}
}
