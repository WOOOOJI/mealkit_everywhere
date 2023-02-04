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


}
