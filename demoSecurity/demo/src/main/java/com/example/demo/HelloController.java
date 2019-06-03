package com.example.demo;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(@RequestParam(name="name",required=false,defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		
		String result;
		
		if (LocalTime.now().getHour() < 12) {
			result = "Bom Dia!";
		} else if (12 <= LocalTime.now().getHour() && LocalTime.now().getHour() < 18) {
			result = "Boa Tarde!";
		} else {
			result = "Boa Noite!";
		}
		
		model.addAttribute("result", result);
		
		return "hello";
	}

	@GetMapping("/time")
	public String time(Model model) {

		model.addAttribute("hora", ("" + LocalTime.now()).substring(0, 8) );
		
		return "time";
	}

}
