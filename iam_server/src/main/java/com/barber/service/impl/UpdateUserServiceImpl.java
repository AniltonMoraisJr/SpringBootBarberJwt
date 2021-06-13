package com.barber.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber.domain.entity.User;
import com.barber.domain.repository.UserRepository;
import com.barber.dto.UpdateUserRequestDTO;
import com.barber.service.UpdateUserService;

@Service
public class UpdateUserServiceImpl implements UpdateUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User update(UUID id, UpdateUserRequestDTO request) {
		Optional<User> uOpt = this.userRepository.findById(id);
		if(!uOpt.isPresent()) {
			throw new NoSuchElementException("User not founded");
		}
		
		User updatedUser = uOpt.get();
		updatedUser.setName(request.getName());
		updatedUser.setEmail(request.getEmail());
		updatedUser.setUsername(request.getUsername());
		
		return this.userRepository.save(updatedUser);
	}

}
