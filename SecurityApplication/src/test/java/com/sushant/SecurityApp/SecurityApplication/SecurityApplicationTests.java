package com.sushant.SecurityApp.SecurityApplication;

import com.sushant.SecurityApp.SecurityApplication.entities.User;
import com.sushant.SecurityApp.SecurityApplication.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = SecurityApplication.class)
class SecurityApplicationTests {

//	@Autowired
//	private JwtService jwtService;
//
//	@Test
//	void contextLoads() {
//
//		User user= new User(4L, "nandysushanta9@gmail.com","12345","sushanta nandy");
//		String token= jwtService.generateAccessToken(user);
//
//		System.out.println(token);
//
//		Long id=jwtService.getUserIdFromTheToken(token);
//		System.out.println(id);
//
//	}

}
