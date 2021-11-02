package com.oup.camelk8shutdownhook.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


@Component
public class SampleRoute extends RouteBuilder {
    Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Override
    public void configure() throws Exception {
        // TODO Auto-generated method stub

        from("timer://foo?repeatCount=1").routeId("id_SampleRoute")
        .log(LoggingLevel.INFO,logger,"Timer Route Started")
        .delay(120000)
        .to("mock:test");
        
    }
    
}
