package com.fms.smartbutler.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fms.smartbutler.dto.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
	public void saveUserLogin(User.UserLogin userLogin) {
		em.persist(userLogin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUser() {
		Query query = em.createQuery("SELECT u FROM User u");
		return query.getResultList();
	}

	@Override
	public Optional<User> findByUserId(Long userId) {
		User user = em.find(User.class, userId);
		return Optional.ofNullable(user);
	}

	@Override
	public void deleteUser(Long userId) {
		User user = em.find(User.class, userId);
		em.remove(user);
	}

}
