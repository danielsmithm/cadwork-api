package br.com.imd.cadeduc.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()
          .apis(RequestHandlerSelectors.basePackage("br.com.imd.cadeduc"))
          .paths(PathSelectors.regex("/.*"))
          .build()
          .apiInfo(metaData());

    }
    
	private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "CADEduc",
                "Spring Boot REST API para Geocalização de escolas",
                "1.0",
                "Termos e Serviço",
                new Contact("CADEduc", "https://cadeduc.imd.com.br/about/", "miguelwelligton@gmail.com"),
               "GNU General Public License 3.0",
                "https://www.gnu.org/licenses/gpl.txt", new ArrayList<>() );
        return apiInfo;
    }
}