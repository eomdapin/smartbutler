package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Users user = usersRepository.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return User
				.builder()
				.username(user.getName())
				.password(user.getPw())
				.roles(user.getRole())
				.build();
	}
	
	public void insert(UsersDTO usersDTO) {
		Users users = modelMapper.map(usersDTO, Users.class);
		
		usersRepository.save(users);
		usersDTO.setUserId(users.getUserId());
	}
	
	public void update(UsersDTO usersDTO) {
		Users users = modelMapper.map(usersDTO, Users.class);
		
		usersRepository.save(users);
		usersDTO.setUserId(users.getUserId());
	}
	
	
	public Optional<UsersDTO> findById(Long userId) {
		Optional<Users> users = usersRepository.findById(userId);
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
		Users users = modelMapper.map(usersDTO, Users.class);
		
		usersRepository.delete(users);
	}
}
