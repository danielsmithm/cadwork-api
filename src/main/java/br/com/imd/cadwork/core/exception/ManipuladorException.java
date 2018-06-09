package br.com.imd.cadwork.core.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.imd.cadwork.core.config.DetalheError;
import br.com.imd.cadwork.core.config.ResponseMessagesConfig;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.core.service.exception.ResourceConflictException;
import br.com.imd.cadwork.core.service.exception.ResourceEmptyException;
import br.com.imd.cadwork.core.service.exception.ResourceNotFoundException;

/**
 * Handler que atua entre as classes de exceções
 * Formatando as exceções emitidas e as padronizando
 * @author miguel
 *
 */
@ControllerAdvice
public class ManipuladorException {

	/**
	 * Captura a exceção lançada do tipo {@link br.com.imd.cadwork.core.service.exception.ResourceEmptyException} 
	 * @param e Exceção lançada
	 * @param request Requisição que causou a exceção
	 * @return ResponseEntity<DetalheError> - Response com a mensagem correspondente a exceção
	 */
	@ExceptionHandler(ResourceEmptyException.class)
	public ResponseEntity<DetalheError> manipuladorResourceEmptyException(GenericServiceException e,
			HttpServletRequest request) {

		DetalheError error = gerarMensagemError(HttpStatus.NOT_ACCEPTABLE, e);

		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
	}

	/**
	 * Captura a exceção lançada do tipo {@link br.com.imd.cadwork.core.service.exception.ResourceNotFoundException} 
	 * @param e Exceção lançada
	 * @param request Requisição que causou a exceção
	 * @return ResponseEntity<{@link br.com.imd.cadwork.core.config.DetalheError}> - Response com a mensagem correspondente a exceção
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<DetalheError> manipuladorResourceNotFoundException(GenericServiceException e,
			HttpServletRequest request) {

		DetalheError error = gerarMensagemError(HttpStatus.NOT_FOUND, e);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	/**
	 * Captura a exceção lançada do tipo {@link br.com.imd.cadwork.core.service.exception.ResourceConflictException} 
	 * @param e Exceção lançada
	 * @param request Requisição que causou a exceção
	 * @return ResponseEntity<{@link br.com.imd.cadwork.core.config.DetalheError}> - 
	 * Response com a mensagem correspondente a exceção
	 */
	@ExceptionHandler(ResourceConflictException.class)
	public ResponseEntity<DetalheError> manipuladorResourceConflictException(GenericServiceException e,
			HttpServletRequest request) {

		DetalheError error = gerarMensagemError(HttpStatus.CONFLICT, e);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	/**
	 * Procedimento que dada uma exceção juntamente com o status da mensagem pertencente ao protocolo http,
	 * formata uma mensagem padrão de resposta ao usuário
	 * @param status - Status correspondente ao verbo http
	 * @param e exceção lançada
	 * @return {@link br.com.imd.cadwork.core.config.DetalheError} - Mensagem padronizada referente a exceção recebida
	 */
	private DetalheError gerarMensagemError(HttpStatus status, GenericServiceException e) {
		DetalheError error = new DetalheError();

		error.setStatus(status);
		error.setTitulo(ResponseMessagesConfig.getInstance().getMensagens()
							.get(status.ordinal()).getMessage());

		error.setTimestamp(System.currentTimeMillis());
		error.setMensagem(e.getMessage().replaceAll("\"", ""));

		return error;
	}

}
