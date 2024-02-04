package com.fms.smartbutler.domain;

/**
* @author 엄다빈
* @editDate 2024-01-24 ~ 2024-01-25
*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "image_category")
public class ImageCategory {
	
	@Id
	@Column(name = "coded", columnDefinition = "char(20)")
	private String coded;
	
	@Column(name = "code_name")
	private String codeName;
}
