package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Users;
import com.fms.smartbutler.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
	
	private final UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Users user = userRepository.findByName(name);
		
		if(user == null) {
			throw new UsernameNotFoundException(name);
		}
		
		return User
				.builder()
				.username(user.getName())
				.password(user.getPw())
				.roles(user.getRole())
				.build();
	}
	
	public void insert(Users user) {
		userRepository.save(user);
	}
	
	public void update(Users user) {
		userRepository.save(user);
	}
	
	public void delete(Users user) {
		userRepository.delete(user);
	}
	
	public Optional<Users> findById(Long userId) {
		return userRepository.findById(userId);
	}
	
	public List<Users> findAll() {
		return userRepository.findAll();
	}
	
}
