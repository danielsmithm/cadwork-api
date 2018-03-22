package br.com.imd.cadeduc.config;

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;

public class ResponseMessagesConfig {
		
	private static ResponseMessagesConfig instancia;
	private static Map<Integer, ResponseMessage> mensagens;
	

	private ResponseMessagesConfig() {
		mensagens = new HashMap<>();
		mensagensPadroes();
	}
	

	private void mensagensPadroes() {
		mensagens.put(new Integer(HttpStatus.NOT_FOUND.ordinal()), new ResponseMessageBuilder()
										.code(HttpStatus.NOT_FOUND.value())
										.message("Recurso não encontrado.")
										.responseModel(new ModelRef("Error"))
										.build());
					
		mensagens.put(new Integer(HttpStatus.OK.ordinal()), new ResponseMessageBuilder()
										.code(HttpStatus.OK.value())
										.message("Sucesso ao visualizar o recurso.")
										.responseModel(new ModelRef("Ok"))
										.build());
		
		mensagens.put(new Integer(HttpStatus.UNAUTHORIZED.ordinal()), new ResponseMessageBuilder()
										.code(HttpStatus.UNAUTHORIZED.value())
										.message("Você não está autorizado a visualizar o recurso.")
										.responseModel(new ModelRef("Unauthorized"))
										.build());
		
		mensagens.put(new Integer(HttpStatus.FORBIDDEN.ordinal()), new ResponseMessageBuilder()
										.code(HttpStatus.FORBIDDEN.value())
										.message("Acesso ao recurso proibido")
										.responseModel(new ModelRef("Forbidden"))
										.build());
	}

	public static ResponseMessagesConfig getInstance() {
		
		if (instancia == null) {
			synchronized(ResponseMessagesConfig.class) {
				if (instancia == null) {
					instancia = new ResponseMessagesConfig();
				}
			}
		}
		return instancia;
	}
	
	
	public ArrayList<ResponseMessage> listaMensagens() {	
		
		return newArrayList(mensagens.values());
		
	}
	
}
