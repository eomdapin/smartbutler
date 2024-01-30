package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fms.smartbutler.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByUsername(String username);
}