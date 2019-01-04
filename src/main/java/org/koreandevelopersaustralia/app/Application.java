package org.koreandevelopersaustralia.app;

import javax.annotation.PostConstruct;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ImportResource({ "classpath:spring/context.xml" })
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void postProcess() {

	}

	/**
	 * This is only a simple redirect to access swagger UI easier from "/swagger-ui"
	 * to "/swagger-ui/index.html?url=/api/swagger&validatorUrl="
	 */
	@Controller
	class SwaggerWelcome {
		@RequestMapping("/swagger-ui")
		public String redirectToUi() {
			return "redirect:/webjars/swagger-ui/index.html?url=/api/swag";
		}
	}
	
	@Component
	class CamelRouter extends RouteBuilder {
	    @Override
	    public void configure() throws Exception {
	    	rest("/"); // trigger
	    }
	}

	/**
	 * Welcome
	 *
	 */
	@RestController
	class SpringRestService {
		@RequestMapping("/")
		public String welcome() {
			return "Welcome to KDA API!";
		}
	}
	
	
}
