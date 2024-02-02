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

import com.fms.smartbutler.domain.Company;
import com.fms.smartbutler.dto.CompanyDTO;
import com.fms.smartbutler.repository.CompanyRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService implements UserDetailsService {

	private final CompanyRepository companyRepository;
	private final ModelMapper modelMapper;
	
	@Override
	public UserDetails loadUserByUsername(String companyName) throws UsernameNotFoundException {
		Company company = companyRepository.findByCompanyName(companyName);

		if (company == null) {
			throw new UsernameNotFoundException(companyName);
		}

		return User
				.builder()
				.username(company.getCompanyName())
				.password(company.getPassword())
				.roles(company.getRole())
				.build();
	}
	
	public CompanyDTO save(CompanyDTO companyDTO) {
		String kindName = companyDTO.getKindName();
		String kindType = "";

		switch (kindName) {
		case "공조":
			kindType = "1";
			break;
		case "엘리베이터":
			kindType = "2";
			break;
		case "전기":
			kindType = "3";
			break;
		default:
			break;
		}
		companyDTO.setKindType(kindType);

		Company company = modelMapper.map(companyDTO, Company.class);

		String role = "WORKER";
		company.setRole(role);

		Company savedCompany = companyRepository.save(company);
		CompanyDTO savedCompanyDTO = modelMapper.map(savedCompany, CompanyDTO.class);
		return savedCompanyDTO;
	}
	
	public CompanyDTO findByCompanyName(String companyName) {
		Company company = companyRepository.findByCompanyName(companyName);
		CompanyDTO companyDTO = modelMapper.map(company, CompanyDTO.class);
		return companyDTO;
	}

	public CompanyDTO findById(Long companyId) {
		Company company = companyRepository.findById(companyId).get();
		CompanyDTO companyDTO = modelMapper.map(company, CompanyDTO.class);
		return companyDTO;
	}

	public List<CompanyDTO> findAll() {
		List<Company> companies = companyRepository.findAll();

		List<CompanyDTO> companiesDTO = companies.stream().map(company -> modelMapper.map(company, CompanyDTO.class))
				.collect(Collectors.toList());

		return companiesDTO;
	}

	public void deleteById(Long companyId) {
		companyRepository.deleteById(companyId);
	}
	
	public Optional<CompanyDTO> findByName(String companyName) {
		Company company = companyRepository.findByCompanyName(companyName);
		CompanyDTO companyDTO = modelMapper.map(company, CompanyDTO.class);
		
		return Optional.ofNullable(companyDTO);
	}
//	public void deleteByCompanyName(String companyName) {
//		companyRepository.deleteByCompanyName(companyName);
//	}

}
