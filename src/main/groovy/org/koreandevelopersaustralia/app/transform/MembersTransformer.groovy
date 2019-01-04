package org.koreandevelopersaustralia.app.transform;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MembersTransformer {

	public Map transform(Map input) {
		def response = [:]
		response.put("members", input?.members?.email_address?.collect { 
			it.replaceAll('(^[^@]{4}|(?!^)\\G)[^@]', '$1*') 
		})
		return response;
	}
}
