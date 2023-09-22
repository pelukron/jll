package com.pelukron.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		try{
			new Lista().menu();
		} catch(Exception e) {
			System.err.println(e);
		}

	}

}