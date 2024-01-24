package com.fms.smartbutler.repository;

import java.util.List;

import com.fms.smartbutler.dto.User;

public interface UserRepository {
	
	void saveUser(User user);
	void saveUserLogin(User.UserLogin userLogin);
	List<User> findAllUser();

}
