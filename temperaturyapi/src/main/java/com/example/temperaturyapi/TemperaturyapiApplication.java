package com.example.temperaturyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TemperaturyapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperaturyapiApplication.class, args);
	}
}

@RestController
class TestController {

	@GetMapping("/test")
	public String test() {
		return "OK DZIALA";
	}
}