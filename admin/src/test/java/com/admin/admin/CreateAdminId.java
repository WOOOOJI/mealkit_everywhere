package com.admin.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.admin.service.AdminService;

@SpringBootTest
public class CreateAdminId {
	@Autowired
	AdminService as;
	
	@Autowired
	PasswordEncoder pwdEncoder;
	
	@Test
	void contextLoads() {
		System.out.println("-------- 관리자 생성 테스트 시작 ---------");

		String adminId="mealkit";
		String adminPwd="1111";
		String name="mealkit";
		
		String encodedPwd=pwdEncoder.encode(adminPwd);
		
		int result=as.createId(adminId, encodedPwd, name);
		
		if(result>0) {
			System.out.println("가입성공~~~~~");
		}else {
			System.out.println("가입실패!!!!!");
		}

		System.out.println("-------- 관리자 생성 테스트 끝 ---------");
	}

}
