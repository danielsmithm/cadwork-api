package br.com.imd.cadwork.util;

import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.google.gson.Gson;

public class ValidatorUtil {
	/**
	 * Gera Json com os errors obtidos 
	 * @param allErrors Lis<ObjectError> - lista de objeto com todos os errors
	 * @return String - Json com os errors
	 */
	public static String gerarErrorsInJson(List<ObjectError> allErrors) {

		StringBuilder message = new StringBuilder();
		message.append("{Errors:[");
		for (ObjectError error : allErrors) {
			message.append("{");
			message.append(((FieldError) error).getField().concat(": "+ error.getDefaultMessage()));
			message.append("}");
			message.append(",");
		}
		message.append("]");

		String errors = message.toString().replace("},]", "}]}");

		return new Gson().toJson(errors);
	}
	/**
	 * Verifica se um objeto está vazio
	 * @param o Object - um objeto qualquer
	 * @return boolean - se o objeto está vazio ou não
	 */
	public static boolean isEmpty(Object o) {
		//Validar de forma genérica quando um objeto está ou não válido
		return true;
	}

}
