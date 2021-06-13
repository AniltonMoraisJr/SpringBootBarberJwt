package com.barber.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber.dto.AuthenticationRequestDTO;
import com.barber.dto.RegisterUserRequestDTO;
import com.barber.service.AuthenticateUserService;
import com.barber.service.RegisterUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Authentication and Register")
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthenticateUserService authenticateUserService;
	
	@Autowired
	private RegisterUserService registerUserService;
	
	@ApiOperation(value = "Sign In")
	@PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthenticationRequestDTO request) {
        return ResponseEntity.ok(this.authenticateUserService.authenticate(request));
    }
	
	@ApiOperation(value = "Sign Up")
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterUserRequestDTO request) {
        boolean result = this.registerUserService.register(request);
        if(result == false) {
        	return new ResponseEntity<String>("Error on save user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok("User created");
    }
}
