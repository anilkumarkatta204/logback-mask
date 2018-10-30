package com.five.three;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class PropertyProcessor {

	@Autowired
	private Environment env;

	public void displayAllProperties() {
		Map<String, Object> map = new HashMap();
		for (Iterator it = ((AbstractEnvironment) env).getPropertySources().iterator(); it.hasNext();) {
			org.springframework.core.env.PropertySource propertySource = (org.springframework.core.env.PropertySource) it
					.next();
			if (propertySource instanceof MapPropertySource) {
				map.putAll(((MapPropertySource) propertySource).getSource());
			}
		}
		// loop a Map
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if(entry.getKey().contains("log.pattern"))
				System.out.println("Key : " + entry.getKey() + " Value : " + (String) entry.getValue());
		}

	}
}
