package com.fms.smartbutler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Resident;

public interface ResidentRepository extends JpaRepository<Resident, Long>{
	List<Resident> findAllByEnteredAndBuild_BuildId(Long entered, Long buildId);
}
