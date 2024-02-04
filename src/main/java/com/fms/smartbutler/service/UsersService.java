package com.fms.smartbutler.service;

/**
* @author 정시운
* @editDate 2024-01-24 ~ 2024-01-26
*/

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Users;
import com.fms.smartbutler.dto.UsersDTO;
import com.fms.smartbutler.repository.UsersRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersService implements UserDetailsService {
	
	private final UsersRepository usersRepository;
	private final ModelMapper modelMapper;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Users user = usersRepository.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return User
				.builder()
				.username(user.getEmail())
				.password(user.getPw())
				.roles(user.getRole())
				.build();
	}
	
	public void insert(UsersDTO usersDTO) {
		Users users = modelMapper.map(usersDTO, Users.class);
		users.encodePassword(passwordEncoder);
		
		usersRepository.save(users);
		usersDTO.setUserId(users.getUserId());
	}
	
	public void update(UsersDTO usersDTO) {
		Users users = modelMapper.map(usersDTO, Users.class);
		users.encodePassword(passwordEncoder);
		
		usersRepository.save(users);
		usersDTO.setUserId(users.getUserId());
	}
	
	public void updateStatus(UsersDTO usersDTO) {
		Users users = modelMapper.map(usersDTO, Users.class);
		usersRepository.save(users);
	}
	
	public Optional<UsersDTO> findById(Long userId) {
		Optional<Users> users = usersRepository.findById(userId);
		UsersDTO usersDTO = modelMapper.map(users, UsersDTO.class);
		
		return Optional.ofNullable(usersDTO);
	}
	
	public Optional<UsersDTO> findByEmail(String email) {
		Users users = usersRepository.findByEmail(email);
		UsersDTO usersDTO = modelMapper.map(users, UsersDTO.class);
		
		return Optional.ofNullable(usersDTO);
	}
	
	public List<UsersDTO> findAll() {
		List<Users> usersList = usersRepository.findAll();
		List<UsersDTO> usersDTOList = usersList
											.stream()
											.map(i ->
												modelMapper
												.map(i, UsersDTO.class))
												.collect(Collectors.toList());
		
		return usersDTOList;
	}
	
	public void delete(UsersDTO usersDTO) {
		if(usersDTO.getStatus() == 2) {
			return;
		}
		
		Users users = modelMapper.map(usersDTO, Users.class);
		
		usersRepository.delete(users);
	}
}
