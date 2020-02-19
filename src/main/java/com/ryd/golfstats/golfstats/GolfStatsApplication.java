package com.ryd.golfstats.golfstats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class GolfStatsApplication {

	@GetMapping("/")
	public String welcome2User(Principal principal){

		return "Hi " + principal.getName() + " Welcome to GolfStats! ";
	}

	public static void main(String[] args) {
		SpringApplication.run(GolfStatsApplication.class, args);
	}

}
