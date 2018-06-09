package br.com.imd.cadwork.core.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;
/**
 * Classe para configurar resource principal
 * @author Welligton Miguel
 *
 */
@ApiIgnore
@RestController
public class CadeducResources {
	/**
	 * Redireciona para página inicial
	 * @param response HttpServletResponse
	 */
	@GetMapping("/")
	public void paginaInicial(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", "/swagger-ui.html");
        response.setHeader("Connection", "close");
	}
}
