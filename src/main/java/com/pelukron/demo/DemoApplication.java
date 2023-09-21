package com.example.demo;

import com.pelukron.demo.Lista;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		try {
			Lista list = new Lista();
			list.menu();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}