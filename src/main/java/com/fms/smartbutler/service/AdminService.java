package com.fms.smartbutler.service;

/**
 * @author 전종배
 * @since 2024-01-25 to 2024-01-31
 */

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Admin;
import com.fms.smartbutler.repository.AdminRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService implements UserDetailsService {
	
	private final AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByUsername(username);
		
		if(admin == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return User
				.builder()
				.username(admin.getUsername())
				.password(admin.getPassword())
				.roles(admin.getRole())
				.build();
	}
}