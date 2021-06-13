package com.barber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.barber.dto.AuthenticationRequestDTO;
import com.barber.dto.AuthenticationResponseDTO;
import com.barber.security.JwtTokenProvider;
import com.barber.security.UserPrincipal;
import com.barber.service.AuthenticateUserService;

@Service
public class AuthenticateUserServiceImpl implements AuthenticateUserService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider tokenProvider;

	@Override
	public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request) {
      Authentication authentication = authenticationManager.authenticate(
		      new UsernamePasswordAuthenticationToken(
		              request.getUsernameOrEmail(),
		              request.getPassword()
		      )
		);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = tokenProvider.generateToken(authentication);
		UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
		
		
		return new AuthenticationResponseDTO(jwt, user);
	}

}
