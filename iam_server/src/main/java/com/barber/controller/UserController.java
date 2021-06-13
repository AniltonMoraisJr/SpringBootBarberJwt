package com.barber.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber.dto.UpdateUserRequestDTO;
import com.barber.service.UpdateUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "User")
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UpdateUserService updateUserService;
	
	@ApiOperation(value = "Update User")
	@PatchMapping("/{id}")
    public ResponseEntity<?> authenticateUser(@PathVariable UUID id, @Valid @RequestBody UpdateUserRequestDTO request) {
        return ResponseEntity.ok(this.updateUserService.update(id, request));
    }
}
