package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fms.smartbutler.domain.Admin;

/**
 * @author 전종배
 * @since 2024-01-25 to 2024-01-31
 */

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByUsername(String username);
}