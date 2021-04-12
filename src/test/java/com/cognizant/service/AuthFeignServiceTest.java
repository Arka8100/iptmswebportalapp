package com.cognizant.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.clients.AuthenticationFeign;
import com.cognizant.model.Admin;

@ExtendWith(MockitoExtension.class)
class AuthFeignServiceTest {

	@Mock
	private AuthenticationFeign authClient;

	@InjectMocks
	AuthFeignService authFeignService;

//	@Mock
//	ResponseEntity<> responseEntity;

	@Test
	void testGetToken() {
		Admin admin = new Admin("1", "password", "user", "token");

		authFeignService.getToken(admin);
	}

}
