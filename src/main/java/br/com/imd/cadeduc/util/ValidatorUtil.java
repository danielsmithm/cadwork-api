package br.com.imd.cadeduc.util;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.google.gson.Gson;

public class ValidatorUtil {

	public static String gerarErrorsInJson(List<ObjectError> allErrors) {

		StringBuilder message = new StringBuilder();
		message.append("Errors:[");
		for (ObjectError error : allErrors) {
			message.append("{");
			message.append(error.getDefaultMessage().concat(": " + ((FieldError) error).getField()));
			message.append("}");
			message.append(",");
		}
		message.append("]");
		
		String errors = message.toString().replace("},]","}]");

		return new Gson().toJson(errors);
	}

	public static ResponseEntity<String> gerarRespostaInJson(String recursor,HttpStatus status) {
		return new ResponseEntity<String>(
				new Gson().toJson("Escola cadastrada com sucesso!"),status);
	}

}
