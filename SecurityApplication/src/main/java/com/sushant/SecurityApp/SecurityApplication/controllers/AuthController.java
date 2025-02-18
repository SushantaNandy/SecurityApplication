package com.sushant.SecurityApp.SecurityApplication.controllers;

import com.sushant.SecurityApp.SecurityApplication.dto.LoginDto;
import com.sushant.SecurityApp.SecurityApplication.dto.SignUpDto;
import com.sushant.SecurityApp.SecurityApplication.dto.UserDto;
import com.sushant.SecurityApp.SecurityApplication.services.AuthService;
import com.sushant.SecurityApp.SecurityApplication.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
       UserDto userDto= userService.signup(signUpDto);
       return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpServletResponse response){
        String token = authService.login(loginDto);

        Cookie cookie= new Cookie("token", token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return ResponseEntity.ok(token);
    }

}
