package com.oup.camelk8shutdownhook.shutdownmanager;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShutDownController {
    
    Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
    @Autowired
    @Qualifier("springManagedShutdownManager")
    private ShutdownManager shutdownManager;

    @GetMapping("/prestop")
    public String shutDown(){
        logger.info("Shutting Down");
        try {
            shutdownManager.initiateShutdown();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return "SHUTDOWN";
    }

    
}
