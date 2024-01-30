package com.fms.smartbutler.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class OptionVo {
	
	private List<String> options;
	
	public OptionVo() {
		this.options = new ArrayList<String>();
		this.options.add("전기");
		this.options.add("수도");
		this.options.add("냉난방기");
		this.options.add("엘리베이터");
		this.options.add("기타");
	}
}
