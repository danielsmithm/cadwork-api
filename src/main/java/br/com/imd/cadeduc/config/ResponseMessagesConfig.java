package br.com.imd.cadeduc.config;

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;


/**
 * Classe que define as mensagens de respostas para solicitações http
 * @author miguel
 * @version 0.4
 *
 */
public class ResponseMessagesConfig {
	
	private static ResponseMessagesConfig instancia;
	private static Map<Integer, ResponseMessage> mensagens;
	

	private ResponseMessagesConfig() {
		mensagens = new HashMap<>();
		mensagensPadroes();
	}
	

	/**
	 * Procedimento que popula o mapa de mensagens com as mensagens padrões
	 */
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
		mensagens.put(new Integer(HttpStatus.NOT_ACCEPTABLE.ordinal()), new ResponseMessageBuilder()
										.code(HttpStatus.NOT_ACCEPTABLE.value())
										.message("Recurso não aceito")
										.responseModel(new ModelRef("Not Acceptable"))
										.build());
		mensagens.put(new Integer(HttpStatus.CONFLICT.ordinal()), new ResponseMessageBuilder()
										.code(HttpStatus.CONFLICT.value())
										.message("Recurso Já existente")
										.responseModel(new ModelRef("Conflict"))
										.build());
	}

	/**
	 * <strong>Singleton</strong>
	 * @return unica instancia para a classe
	 */
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
	
	/**
	 * Função que retorna as mensagens das requisições
	 * @return List<ResponseMessage> - Mensagens padrões das requisições
	 */
	public ArrayList<ResponseMessage> listaMensagens() {	
		
		return newArrayList(mensagens.values());
		
	}


	public Map<Integer, ResponseMessage> getMensagens() {
		return mensagens;
	}
	
	
}
