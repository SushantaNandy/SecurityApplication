package com.sushant.SecurityApp.SecurityApplication.services;

import com.sushant.SecurityApp.SecurityApplication.dto.LoginDto;
import com.sushant.SecurityApp.SecurityApplication.dto.SignUpDto;
import com.sushant.SecurityApp.SecurityApplication.dto.UserDto;
import com.sushant.SecurityApp.SecurityApplication.entities.User;
import com.sushant.SecurityApp.SecurityApplication.exception.ResourceNotFoundException;
import com.sushant.SecurityApp.SecurityApplication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()-> new BadCredentialsException("User not found by email "+username));
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User not found by id "+userId));
    }

    public UserDto signup(SignUpDto signUpDto) {
       Optional<User> user= userRepository.findByEmail(signUpDto.getEmail());
       if (user.isPresent()){
           throw new BadCredentialsException("Username already exist with email +"+ signUpDto.getEmail());
       }

       User toBeCreated= modelMapper.map(signUpDto, User.class);
       toBeCreated.setPassword(passwordEncoder.encode(toBeCreated.getPassword()));
       User savedUser= userRepository.save(toBeCreated);
       return modelMapper.map(savedUser, UserDto.class);
    }


}
