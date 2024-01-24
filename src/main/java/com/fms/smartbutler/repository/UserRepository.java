package com.fms.smartbutler.repository;

import com.fms.smartbutler.dto.User;

public interface UserRepository {
	
	void saveUser(User user);
	void saveUserLogin(User.UserLogin userLogin);

}
