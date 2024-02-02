package com.fms.smartbutler.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Resident;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
	Optional<Resident> findByUser_UserId(Long userId);
}
