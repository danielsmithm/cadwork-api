package br.com.imd.cadeduc.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class CadeducResources {

	@GetMapping("/")
	public void paginaInicial(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", "/swagger-ui.html");
        response.setHeader("Connection", "close");
	}
}
