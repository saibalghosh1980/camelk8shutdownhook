package com.oup.camelk8shutdownhook.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShutDownController {


    @GetMapping("/prestop")
    public String shutDown(){
         System.out.println("Shutting Down");
        return "SHUTDOWN";
    }

    
}
