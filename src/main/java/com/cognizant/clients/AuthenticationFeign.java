package com.cognizant.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.Admin;
import com.cognizant.model.AuthResponse;

/**
 * 
 * Feign provides an abstraction over REST-based calls via annotation, by which
 * microservices can use to communicate with each other without writing detailed
 * REST client code In the @FeignClient annotation the String value ("AUTH") is
 * an arbitrary client name, which is used to create a Ribbon load balancer
 */
@FeignClient(name = "AUTH", url = "http://Iptmsauthjwtnew-env.eba-gbpwwzd3.us-east-2.elasticbeanstalk.com/auth")
public interface AuthenticationFeign {
	/**
	 * to allow a user with valid Credentials to login into the app and access the
	 * functionalities.
	 * 
	 * @param Admin Object
	 * @return ResponseEntity<?> of login
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody Admin userlogincredentials);

	/**
	 * to verify the token that the user request is valid
	 * 
	 * @param token
	 * @return AuthResponse
	 */
	@GetMapping(value = "/validate")
	public AuthResponse verifyToken(@RequestHeader("Authorization") String token);
}
