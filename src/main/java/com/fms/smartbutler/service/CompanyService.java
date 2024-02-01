package com.fms.smartbutler.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Company;
import com.fms.smartbutler.dto.CompanyDTO;
import com.fms.smartbutler.repository.CompanyRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CompanyService implements UserDetailsService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public UserDetails loadUserByUsername(String companyName) throws UsernameNotFoundException {
		Company company = companyRepository.findByCompanyName(companyName);

		if (company == null) {
			throw new UsernameNotFoundException(companyName);
		}

		return User.builder().username(company.getCompanyName()).password(company.getPassword())
				.roles(company.getRole()).build();
	}

	public Company save(Company company) {
		return companyRepository.save(company);
	}

	public Optional<Company> findById(Long companyId) {
		return companyRepository.findById(companyId);
	}

	public List<CompanyDTO> findAll() {

		List<Company> companies = companyRepository.findAll();
//		List<CompanyDTO> companiesDTO = new ArrayList<>();
		
//		for (Company company : companies) {
//			CompanyDTO companyDTO = modelMapper.map(company, CompanyDTO.class);
//			companyDTO.setKindName(company.getCompanyKind().getKindName());		// 없어도 됨
//			companiesDTO.add(companyDTO);
//		}
		
		List<CompanyDTO> companiesDTO = companies
				  .stream()
				  .map(company -> modelMapper.map(company, CompanyDTO.class))
				  .collect(Collectors.toList());
		
		return companiesDTO;
	}

	public void deleteById(Long companyId) {
		companyRepository.deleteById(companyId);
	}

}
