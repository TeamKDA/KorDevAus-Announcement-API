package org.koreandevelopersaustralia.app.transform;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwaggerTransformer {

	@Value("${camel.rest.scheme}")
	private String scheme;
	
	public Map transform(Map input) {
		input.put("schemes", new String[]{scheme});
		return input;
	}
}
