package com.fms.smartbutler.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "image_category")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ImageCategory {
	
	@Id
	private String code;
	
	@Column(name = "code_name")
	private String codeName;
}
