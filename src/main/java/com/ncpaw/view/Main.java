package com.ncpaw.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author santiagobernal
 *
 */
@ComponentScan
@SpringBootApplication
public class Main {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}
}
