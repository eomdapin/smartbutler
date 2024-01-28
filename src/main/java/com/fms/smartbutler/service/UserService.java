package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.User;
import com.fms.smartbutler.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	public void insert(User user) {
		userRepository.save(user);
	}
	
	public void update(User user) {
		userRepository.save(user);
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
}
