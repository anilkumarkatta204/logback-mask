package com.five.three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogbackMaskApplication implements CommandLineRunner {

	@Autowired 
	private BusinessService bService;
	
	@Autowired
	private PropertyProcessor pr;
	
	public static void main(String[] args) {
		SpringApplication.run(LogbackMaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bService.someBusiness("MY Account Number: 1234567890123456");
		bService.someBusiness("MY SSN Number: 345-55-6789");
		pr.displayAllProperties();
	}
}
