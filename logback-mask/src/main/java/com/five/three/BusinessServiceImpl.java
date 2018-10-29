package com.five.three;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class BusinessServiceImpl implements BusinessService {
	
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(BusinessServiceImpl.class);

	@Override
	public void someBusiness(String msg) {
		LOGGER.trace("someBusiness needed more information - {}", msg);
        LOGGER.debug("someBusiness needed to debug - {}", msg);
        LOGGER.info("someBusiness took input - {}", msg);
        LOGGER.warn("someBusiness needed to warn - {}", msg);
        LOGGER.error("someBusiness encountered an error with value - {}", msg);
        LOGGER.info("123412341");
        
		
	}

}
