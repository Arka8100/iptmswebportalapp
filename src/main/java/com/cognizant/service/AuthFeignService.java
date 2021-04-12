package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.clients.AuthenticationFeign;
import com.cognizant.model.Admin;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Service Class For Authentication
 * 
 * @slf4j Causes lombok to generate a logger field.
 * @Service Indicates that an annotated class is a "Service", originally defined
 *          by Domain-DrivenDesign (Evans, 2003) as "an operation offered as an
 *          interface that stands alone in the model, with no encapsulated
 *          state."
 */
@Slf4j
@Service
public class AuthFeignService {

	@Autowired
	private AuthenticationFeign authClient;

	public ResponseEntity<?> getToken(Admin usercredentials) {
		log.debug("userCredentials{}:", usercredentials);
		return authClient.login(usercredentials);
	}

}