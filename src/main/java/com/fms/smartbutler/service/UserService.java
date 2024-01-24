package com.fms.smartbutler.service;

import org.springframework.stereotype.Service;

import com.fms.smartbutler.dto.User;
import com.fms.smartbutler.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
	
	private final UserRepository userRepository;
	
	public void save(User user, User.UserLogin userLogin) {
		log.info(""+userLogin.getUserId());
		userRepository.saveUser(user);
		log.info(""+user.getUserId());
		userLogin.setUserId(user.getUserId());
		
		log.info("userLogin.id >> "+userLogin.getUserId());
		log.info("userLogin.password >> "+userLogin.getPw());
		
		userRepository.saveUserLogin(userLogin);
		
	}
	
}
