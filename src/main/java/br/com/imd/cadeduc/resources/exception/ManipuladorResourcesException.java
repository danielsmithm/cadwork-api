package br.com.imd.cadeduc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.imd.cadeduc.config.DetalheError;
import br.com.imd.cadeduc.config.ResponseMessagesConfig;
import br.com.imd.cadeduc.service.exception.ResourceEmptyException;

@ControllerAdvice
public class ManipuladorResourcesException {

	@ExceptionHandler(ResourceEmptyException.class)
	public ResponseEntity<DetalheError> manipuladorResourceEmptyException(ResourceEmptyException e,
			HttpServletRequest request) {

		DetalheError error = new DetalheError();
		
		error.setStatus(HttpStatus.NOT_ACCEPTABLE);
		error.setTitulo(ResponseMessagesConfig.getInstance().getMensagens().
				get(HttpStatus.NOT_ACCEPTABLE.ordinal()).getMessage());
		
		error.setTimestamp(System.currentTimeMillis());
		error.setMensagem(e.getMessage().replaceAll("\"", ""));
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
	}
}
