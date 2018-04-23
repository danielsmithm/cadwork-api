package br.com.imd.cadeduc.core.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.imd.cadeduc.core.config.DetalheError;
import br.com.imd.cadeduc.core.config.ResponseMessagesConfig;
import br.com.imd.cadeduc.core.service.exception.GenericServiceException;
import br.com.imd.cadeduc.core.service.exception.ResourceConflictException;
import br.com.imd.cadeduc.core.service.exception.ResourceEmptyException;
import br.com.imd.cadeduc.core.service.exception.ResourceNotFoundException;

@ControllerAdvice
public class ManipuladorException {

	@ExceptionHandler(ResourceEmptyException.class)
	public ResponseEntity<DetalheError> manipuladorResourceEmptyException(GenericServiceException e,
			HttpServletRequest request) {

		DetalheError error = gerarMensagemError(HttpStatus.NOT_ACCEPTABLE, e);

		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<DetalheError> manipuladorResourceNotFoundException(GenericServiceException e,
			HttpServletRequest request) {

		DetalheError error = gerarMensagemError(HttpStatus.NOT_FOUND, e);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(ResourceConflictException.class)
	public ResponseEntity<DetalheError> manipuladorResourceConflictException(GenericServiceException e,
			HttpServletRequest request) {

		DetalheError error = gerarMensagemError(HttpStatus.CONFLICT, e);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

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
