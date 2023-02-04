package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.AdminDTO;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface AdminMapper extends MyMapper<Integer, AdminDTO>{
	
	//관리자 로그인 하기
	public AdminDTO login(String adminId, String adminPwd) throws Exception;
	
	//관리자 아이디 생성
	public int createId(String adminId, String adminPwd, String name) throws Exception;
	//관리자 비밀번호 변경
	public int updatePwd(String adminId, String adminPwd) throws Exception;
	
	//관리자 ID 이용해서 해당 ID의 pwd 불러오기
	public String getPwd(String adminId) throws Exception;
}
