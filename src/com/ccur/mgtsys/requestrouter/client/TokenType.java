package com.ccur.mgtsys.requestrouter.client;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;

public class TokenType {
	private Map<String, Object> properties = new HashMap<>();
	
	@JsonAnySetter
    public void add(String key, String value) {
        properties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "TokenType{" +
                ", properties=" + properties +
                '}';
    }
}

