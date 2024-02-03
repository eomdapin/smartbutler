package com.fms.smartbutler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.fms.smartbutler.domain.Admin;
import com.fms.smartbutler.repository.AdminRepository;

/**
 * @author 전종배
 * @since 2024-01-25 to 2024-01-31
 */

@Service
public class AdminService implements UserDetailsService {
	
	@Autowired private AdminRepository adminRepository;
	@Autowired private PasswordEncoder passwordEncoder;
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
	
	public Admin joinMember(Admin admin) {
		admin.encodePassword(passwordEncoder);
		return adminRepository.save(admin);
	}
	
}