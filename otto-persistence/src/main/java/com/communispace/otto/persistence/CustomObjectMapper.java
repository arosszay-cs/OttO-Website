package com.communispace.otto.persistence;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Component;

@Component
public class CustomObjectMapper extends ObjectMapper {
	public CustomObjectMapper() {
		// place to put global customizations in the future.
		
		//TODO for debugging only, remove for prod
		this.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		
		//couch will sometimes put things in the response like _deleted_conflicts
		this.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		// allow comments - don't choke
		this.configure(JsonParser.Feature.ALLOW_COMMENTS, true);

		// if something is null, don't serialize it 
		this.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

	}
}
