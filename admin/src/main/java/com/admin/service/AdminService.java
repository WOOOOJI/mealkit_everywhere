package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.AdminDTO;
import com.admin.frame.MyService;
import com.admin.mapper.AdminMapper;

@Service
public class AdminService implements MyService<Integer, AdminDTO>{

	@Autowired
	AdminMapper mapper;

	@Override
	public void register(AdminDTO v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(AdminDTO v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public AdminDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public AdminDTO login(String adminId, String adminPwd) {
		AdminDTO dto = null;

		try {
			dto = mapper.login(adminId, adminPwd);
			System.out.println("mapper"+ dto);
		}catch(Exception e) {
			System.out.println("Error Caused by at AdminService row 57 Line");
			e.printStackTrace();
		}


		return dto;
	}
	
	//관리자 아이디 생성
	public int createId(String adminId, String adminPwd, String name) {
		int result=0;
		try {
			result=mapper.createId(adminId, adminPwd, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//관리자 비밀번호 변경
	public int updatePwd(String adminId, String adminPwd) {
		int result=0;
		try {
			result=mapper.updatePwd(adminId, adminPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//관리자 ID 이용해서 해당 ID의 pwd 불러오기
	public String getPwd(String adminId) {
		String result="";
		try {
			result=mapper.getPwd(adminId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
