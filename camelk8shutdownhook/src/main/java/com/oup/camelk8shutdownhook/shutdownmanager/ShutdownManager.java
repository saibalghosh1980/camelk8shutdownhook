package com.oup.camelk8shutdownhook.shutdownmanager;
import java.util.concurrent.TimeUnit;

import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("springManagedShutdownManager")
class ShutdownManager {
	Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private CamelContext camelContext;

	
	public void initiateShutdown() {
		logger.debug("Stopping camel context");
		camelContext.getShutdownStrategy().setLogInflightExchangesOnTimeout(true);
		camelContext.getShutdownStrategy().setTimeUnit(TimeUnit.SECONDS);
		camelContext.getShutdownStrategy().setTimeout(55);
		camelContext.stop();
		logger.debug("Stopping camel context finished");
	}
}

