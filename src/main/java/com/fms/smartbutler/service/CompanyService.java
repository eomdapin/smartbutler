package com.fms.smartbutler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Company;
import com.fms.smartbutler.repository.CompanyRepository;

@Service
public class CompanyService implements UserDetailsService {

	@Autowired private CompanyRepository companyRepository;
	@Override
	public UserDetails loadUserByUsername(String companyName) throws UsernameNotFoundException {
			Company company = companyRepository.findByCompanyName(companyName);
			
			if(company == null) {
				throw new UsernameNotFoundException(companyName);
			}
			
			return User
					.builder()
					.username(company.getCompanyName())
					.password(company.getPassword())
					.roles(company.getRole())
					.build();
		}
	}
	
