package com.fms.smartbutler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

	// [비밀번호 암호화 Bean 등록]
	// : DB에 비밀번호를 평문으로 저장하지 않고 Hash를 진행한 뒤 저장
	// : 단방향 해쉬 알고리듬에 salt를 추가하여 encoding ( 암호화 O 복호화 X )
	// : 
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
