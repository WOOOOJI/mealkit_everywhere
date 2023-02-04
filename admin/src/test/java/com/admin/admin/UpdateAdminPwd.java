package com.admin.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.admin.service.AdminService;

@SpringBootTest
public class UpdateAdminPwd {
	@Autowired
	AdminService as;
	
	@Autowired
	PasswordEncoder pwdEncoder;
	
	@Test
	void contextLoads() {
		System.out.println("-------- 관리자 비밀번호 변경 테스트 시작 ---------");

		String adminId="admin01";
		String adminPwd="1234";
		
		String encodedPwd=pwdEncoder.encode(adminPwd);
		
		int result=as.updatePwd(adminId, encodedPwd);
		
		if(result>0) {
			System.out.println("수정성공~~~~~");
		}else {
			System.out.println("수정실패!!!!!");
		}

		System.out.println("-------- 관리자 비밀번호 변경 테스트 끝 ---------");
	}

}
