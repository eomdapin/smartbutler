package com.fms.smartbutler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 전종배
 * @since 2024-01-25 to 2024-01-31
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
	private Long id;
	private String username;
	private String password;
	private String role;

}