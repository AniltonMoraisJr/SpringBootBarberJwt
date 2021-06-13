package com.barber.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barber.domain.entity.Role;
import com.barber.domain.enums.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
	Optional<Role> findByName(RoleName name);
}
