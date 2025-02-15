package com.sushant.SecurityApp.SecurityApplication;

import com.sushant.SecurityApp.SecurityApplication.entities.User;
import com.sushant.SecurityApp.SecurityApplication.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SecurityApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {

		User user= new User(4l, "nandysushanta9@gmail.com","12345");
		String token= jwtService.generateToken(user);

		System.out.println(token);

		Long id=jwtService.getUserIdFromTheToken(token);
		System.out.println(id);

	}

}
