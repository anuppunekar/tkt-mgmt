package com.mycompany.app.tkt_mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Controller
public class TktMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(TktMgmtApplication.class, args);
	}

	@ResponseBody
	@RequestMapping("/")
	public String sayHello() {
		return "Hello";
	}

	@ResponseBody
	@RequestMapping("/aloha")
	public String sayAloha() {
		return "Aloha";
	}
}
