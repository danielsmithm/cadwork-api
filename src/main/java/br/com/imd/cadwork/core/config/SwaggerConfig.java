package br.com.imd.cadwork.core.config;

import java.time.LocalDate;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe que define as configurações da documentação Swagger
 * 
 * @author miguel
 * @version 0.2
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = SwaggerConfig.class)
public class SwaggerConfig extends WebMvcConfigurationSupport{                                    
	
	/**
	 * Função central que constroi a documentação
	 * @return Docket
	 */
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()
	          .apis(RequestHandlerSelectors.basePackage("br.com.imd"))
	          .paths(PathSelectors.any())
	          .build()
          .pathMapping("/")
          .directModelSubstitute(LocalDate.class, String.class)
          .genericModelSubstitutes(ResponseEntity.class)
          .useDefaultResponseMessages(true)
          .apiInfo(metaData());

    }
    	
	/**
	 * Função que define os metadados da API
	 * @return ApiInfo - informações sobre a criação da API
	 */
	private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "CADWork",
                "Spring Boot REST API para Geocalização de recursos",
                "1.0",
                "Termos e Serviço",
                new Contact("CADEduc", "https://cadwork.imd.com.br/about/", "miguelwelligton@gmail.com"),
               "GNU General Public License 3.0",
                "https://www.gnu.org/licenses/gpl.txt", Collections.emptyList());
        return apiInfo;
    }
	
	/**
	 * Procedimento que define a rota inicial da API para a documentação Swagger
	 * dominio/swagger-ui.html
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addRedirectViewController("/null/v2/api-docs", "/v2/api-docs");
	    registry.addRedirectViewController("/null/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
	    registry.addRedirectViewController("/null/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
	    registry.addRedirectViewController("/null/swagger-resources", "/swagger-resources");
	}

}