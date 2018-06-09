package br.com.imd.cadwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Classe para inicializar aplicação 
 * @author Welligton Miguel
 * @version 0.1
 */
@EnableSwagger2
@SpringBootApplication
public class CadworkapiApplication {
	/**
	 * Função main do framework responsável por inicializar a aplicação 
	 * 
	 * @param args String - argumentos passados na inicialização do programa
	 */
	public static void main(String[] args) {
		SpringApplication.run(CadworkapiApplication.class, args);
	}
}

