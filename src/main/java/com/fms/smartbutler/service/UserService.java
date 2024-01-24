package com.fms.smartbutler.service;

import org.springframework.stereotype.Service;

import com.fms.smartbutler.dto.User;
import com.fms.smartbutler.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	public void save(User user, User.UserLogin userLogin) {
		userRepository.saveUser(user);
		userRepository.saveUserLogin(userLogin);
	}

}
