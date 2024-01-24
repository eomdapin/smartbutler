package com.fms.smartbutler.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fms.smartbutler.dto.User;
import com.fms.smartbutler.dto.User.UserLogin;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Transactional
@Repository
@RequiredArgsConstructor
public class UserRepositoryJpa implements UserRepository{
	private final EntityManager em;

	@Override
	public void saveUser(User user) {
		em.persist(user);
	}

	@Override
	public void saveUserLogin(UserLogin userLogin) {
		em.persist(userLogin);
	}

}
