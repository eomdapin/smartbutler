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
	
	public void save(User user, User.UserLogin userLogin) {
		userRepository.saveUser(user);
		userLogin.setUserId(user.getUserId());
		userRepository.saveUserLogin(userLogin);
	}
	
	public List<User> findAllUser() {
		return userRepository.findAllUser();
	}
	
	public Optional<User> findByUserId(Long userId) {
		return userRepository.findByUserId(userId);
	}
	
	public void deleteUser(Long userId) {
		userRepository.deleteUser(userId);
	}
	
}
