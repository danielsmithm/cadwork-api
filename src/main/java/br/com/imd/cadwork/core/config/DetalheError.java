package br.com.imd.cadwork.core.config;

import org.springframework.http.HttpStatus;
/**
 * Classe modelo das respostas aos errors e seus detalhes 
 * @author Welligton Miguel
 * @version 0.1
 */

public class DetalheError {

	private String titulo;
	private HttpStatus status;
	private Long timestamp;
	private String mensagem;
	
	/**
	 * Método que retorna o titulo do error
	 * @return String - titulo do error
	 */

	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Altera titulo do error
	 * @param titulo String - novo título 
	 */
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Método que retorna o status do error 
	 * @return HttpStatus - status do error
	 */
	
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * Método que altera o status do error
	 * @param status HttpStatus - novo status do error
	 */
	
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	/**
	 * Método que o retorna o time stamp do error
	 * @return Long - time stamp do error
	 */
	
	public Long getTimestamp() {
		return timestamp;
	}
	/**
	 * Método que altera o time stamp do error
	 * @param timestamp Long - novo time stamp
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * Método que retorna a mensagem do error
	 * @return String - mensagem do error
	 */
	
	public String getMensagem() {
		return mensagem;
	}
	/**
	 * Método que altera a mensagem do error
	 * @param mensagem String - nova mensagem do error
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
