package com.fms.smartbutler.domain;

/**
* @author 엄다빈
* @editDate 2024-01-24 ~ 2024-01-25
*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "image")
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private Long imageId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coded")
	private ImageCategory imageCategory = new ImageCategory();
	
	@Column(name = "out_id")
	private Long outId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "real_name")
	private String realName;
	
	@Column(name = "src")
	private String src;
	
	@Column(name = "real_src")
	private String realSrc;
}
