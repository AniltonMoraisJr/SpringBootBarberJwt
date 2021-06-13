package com.barber.service;

import com.barber.dto.AuthenticationRequestDTO;
import com.barber.dto.AuthenticationResponseDTO;

public interface AuthenticateUserService {
	AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
}
