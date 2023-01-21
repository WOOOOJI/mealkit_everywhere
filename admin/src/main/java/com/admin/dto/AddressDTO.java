package com.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AddressDTO {
	private int addrKey;
	private int custKey;
	private String name;
	private String zipcode;
	private String addr;
	private String addrDetail;
	private String tel;
	private String req;
	private String def;
}
