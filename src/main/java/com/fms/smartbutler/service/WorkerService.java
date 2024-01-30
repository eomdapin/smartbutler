package com.fms.smartbutler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Worker;
import com.fms.smartbutler.repository.WorkerRepository;

@Service
public class WorkerService implements UserDetailsService {
	
	@Autowired private WorkerRepository workerRepository;
	@Autowired private PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Worker worker = workerRepository.findByUsername(username);
		
		if(worker == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return User
				.builder()
				.username(worker.getUsername())
				.password(worker.getPassword())
				.roles(worker.getRole())
				.build();
	}
	
	public Worker joinMember(Worker worker) {
		worker.encodePassword(passwordEncoder);
		return workerRepository.save(worker);
	}
	
}