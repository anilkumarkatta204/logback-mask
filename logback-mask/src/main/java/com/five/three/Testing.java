package com.five.three;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

@org.springframework.context.annotation.PropertySource("classpath:/resources/application.properties")
public class Testing {

	public static void main(String[] args) {
		init();

	}
	
	@Autowired
	static
    Environment env;

    public static void init() {
        
        Map<String, Object> map = new HashMap<String, Object>();
        for(Iterator it = ((AbstractEnvironment) env).getPropertySources().iterator(); it.hasNext(); ) {
            PropertySource propertySource = (PropertySource) it.next();
            if (propertySource instanceof MapPropertySource) {
                map.putAll(((MapPropertySource) propertySource).getSource());
            }
        }
        
        System.out.println(map.get("log.pattern.match.socialsecurity"));
        
    }

}
