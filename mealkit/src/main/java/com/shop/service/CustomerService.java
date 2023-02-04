package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.CustomerDTO;
import com.shop.frame.MyService;
import com.shop.mapper.CustomerMapper;

@Service
public class CustomerService implements MyService<Integer, CustomerDTO> {

	@Autowired
	CustomerMapper mapper;

	@Override
	public void register(CustomerDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(CustomerDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public CustomerDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	
	
	// 전체 회원수 가져오기
	@Override
	public List<CustomerDTO> get(){
		List<CustomerDTO> list = null;
		
		try {
			list = mapper.selectall();
		} catch (Exception e) {
			System.out.println("Error Caused By at CustomerService Row 45 line");
			e.getMessage();
		}
		
		return list;
	}

	
	
	// 회원 가입
	public int addMember(CustomerDTO dto) {
		int result = mapper.addMember(dto);
		return result;
	}

	// 아이디 중복 확인
	public int isEmailExist(CustomerDTO dto) throws Exception {
		int result = mapper.isEmailExist(dto);
		return result;
	}

	// 로그인 체크
	public CustomerDTO loginCheck(CustomerDTO dto) throws Exception {
		CustomerDTO result = mapper.loginCheck(dto);
		return result;
	}

	// 아이디 찾기
	public String findId(CustomerDTO dto) throws Exception {
		CustomerDTO result = mapper.findId(dto);

		if (result != null && !result.getEmail().isEmpty()) {
			String[] email = result.getEmail().split("@");

			String id = email[0].substring(0, 2);
			String id2 = email[0].substring(2, email[0].length() - 2).replaceAll("[a-z0-9]", "*");
			String id3 = email[0].substring(email[0].length() - 2);
			String id4 = email[1];

			return id + id2 + id3 + "@" + id4 + "입니다.";
		} else {
			return "유저가 존재하지 않습니다.";

		}
	}
	//아이디와 전화번호가 일치하는 유저
	public CustomerDTO resetPwdForm(CustomerDTO dto) throws Exception{	
		return mapper.resetPwdForm(dto);
	}
	
	public int resetPwd(String pwd1, int custKey) throws Exception{
		return mapper.resetPwd(pwd1, custKey);
	}
	
	//회원탈퇴
	public int signOut(CustomerDTO dto) {
		return mapper.signOut(dto);
	}
	
	
	
	//마이페이지 비밀번호 변경 전 회원정보 확인하기
	public CustomerDTO custCheck(CustomerDTO dto) throws Exception {
		CustomerDTO result = mapper.custCheck(dto);
		return result;
	}
	
	//마이페이지 비밀번호 변경 
	public CustomerDTO updatePwdForm(CustomerDTO dto) throws Exception{	
		return mapper.updatePwdForm(dto);
	}
	
	//로그인 시 사용되는 이메일로 비밀번호 가져오기
	public String getPwd(String email) {
		String result="";
		
		try {
			result=mapper.getPwd(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}






