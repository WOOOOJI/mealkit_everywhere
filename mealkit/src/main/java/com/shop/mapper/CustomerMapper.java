package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.CustomerDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface CustomerMapper extends MyMapper<Integer, CustomerDTO>{
	//회원 가입 
	public int addMember(CustomerDTO dto); 
	
	//회원 아이디 중복 체크
	public int isEmailExist(CustomerDTO dto);
	
	//로그인 체크
	public CustomerDTO loginCheck(CustomerDTO dto);
	
	//아이디 찾기
	public CustomerDTO findId(CustomerDTO dto);
	
	//비밀번호 찾기
	public CustomerDTO findPwd(CustomerDTO dto);
	
	//아이디, 전화번호 일치여부 확인
	public CustomerDTO resetPwdForm(CustomerDTO dto);
	
	//이메일이 일치하는 회원고유번호 가져오기
	public int findCustKey(String email);
	
	// 사용자 비밀번호 재설정
	public int resetPwd(String pwd1, String pwd2, int custKey);
	
	//회원탈퇴
	public int signOut(CustomerDTO dto);
	
	//마이페이지 비밀번호 변경 전 회원정보 확인하기
	public CustomerDTO custCheck(CustomerDTO dto);
	
	//마이페이지 비밀번호 변경
	public CustomerDTO updatePwdForm(CustomerDTO dto);
	
	//로그인 시 입력된 id로 비밀번호 가져오기
	public String getPwd(String email) throws Exception;
}
	 