package com.barber.service;

import java.util.UUID;

import com.barber.domain.entity.User;
import com.barber.dto.UpdateUserRequestDTO;

public interface UpdateUserService {
	User update(UUID id, UpdateUserRequestDTO request);
}
