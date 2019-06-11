package com.example.demo;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Greeting;

@RestController
public class GreetingController {
	
	@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(name, saudacao());
    }
    
    private String saudacao() {
        
        String result = "";

        if (LocalTime.now().getHour() < 12) {
			result = "Bom Dia!";
		} else if (12 <= LocalTime.now().getHour() && LocalTime.now().getHour() < 18) {
			result = "Boa Tarde!";
		} else {
			result = "Boa Noite!";
		}

        return result;
    }
    @RequestMapping("/timeJSON")
    public ServerTime serverTime() {
        return new ServerTime();
    }

}
