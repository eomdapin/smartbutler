package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
	Worker findByUsername(String username);
}