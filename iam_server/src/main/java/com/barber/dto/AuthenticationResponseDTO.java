package com.barber.dto;

import com.barber.security.UserPrincipal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDTO {
	private String accessToken;
    private String tokenType = "Bearer";
    private UserPrincipal user;
	
    public AuthenticationResponseDTO(String token, UserPrincipal user) {
		super();
		this.accessToken = token;
		this.user = user;
	}
    
    
}
