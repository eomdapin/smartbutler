package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;

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
	
	public Company save(Company company) {
		return companyRepository.save(company);
	}

	public Optional<Company> findById(Long companyId) {
		return companyRepository.findById(companyId);
	}

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public void deleteById(Long companyId) {
		companyRepository.deleteById(companyId);
	}
		
}
	
