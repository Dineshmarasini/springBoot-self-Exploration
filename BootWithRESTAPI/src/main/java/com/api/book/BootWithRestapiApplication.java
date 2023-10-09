 package com.api.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.api.helper")
public class BootWithRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootWithRestapiApplication.class, args);
	}

}
