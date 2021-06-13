package com.barber.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.barber.domain.entity.Role;
import com.barber.domain.entity.User;
import com.barber.domain.enums.RoleName;
import com.barber.domain.repository.RoleRepository;
import com.barber.domain.repository.UserRepository;
import com.barber.dto.RegisterUserRequestDTO;
import com.barber.service.RegisterUserService;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public boolean register(RegisterUserRequestDTO request) {
		if(userRepository.existsByUsername(request.getUsername())) {
            return false;
        }

        if(userRepository.existsByEmail(request.getEmail())) {
            return false;
        }
        
		User newUser = request.transformInEntity();
		
		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		
		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
               .orElseThrow(() -> new RuntimeException("User Role not set."));

		newUser.setRoles(Collections.singleton(userRole));
		
		newUser = this.userRepository.save(newUser);
		return true;
	}

}
