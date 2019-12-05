package com.revature;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.revature.models.User;
import com.revature.util.MailService;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		User carolyn = new User(0, "carolyn.rehm@revature.com", "", 0000000, null);
		MailService ms = new MailService();
		ms.sendEmail(carolyn, carolyn);
	}
}
