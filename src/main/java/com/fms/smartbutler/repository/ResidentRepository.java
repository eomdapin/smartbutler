package com.fms.smartbutler.repository;

/**
* @author 엄다빈
* @editDate 2024-02-01 ~ 2024-02-02
*/

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Resident;

public interface ResidentRepository extends JpaRepository<Resident, Long>{
	List<Resident> findAllByEnteredAndBuild_BuildId(Long entered, Long buildId);
	Optional<Resident> findByUsers_UserId(Long userId);
}
