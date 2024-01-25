package com.fms.smartbutler.repository;

import java.util.List;
import java.util.Optional;

import com.fms.smartbutler.dto.User;

public interface UserRepository {
	
	void saveUser(User user);
	void saveUserLogin(User.UserLogin userLogin);
	List<User> findAllUser();
	Optional<User> findByUserId(Long userId);
	void deleteUser(Long userId);

}
