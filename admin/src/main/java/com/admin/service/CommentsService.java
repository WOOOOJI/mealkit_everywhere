package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.CommentsDTO;
import com.admin.frame.MyService;
import com.admin.mapper.CommentsMapper;

@Service
public class CommentsService implements MyService<Integer, CommentsDTO>{

	@Autowired
	CommentsMapper mapper;
	
	@Override
	public void register(CommentsDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(CommentsDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CommentsDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentsDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// 문의 답변 보기
	public CommentsDTO getreply(Integer k){ 
		
		try {
			return mapper.qnaReply(k);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

//------------------------------------------------------------------	
	// 답변 댓글 등록
	public int insertComments(int boardKey, String content){
		int result = 0;
		try {
			result = mapper.insertComments(boardKey, content);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//답변 불러오기
	public List<CommentsDTO> getCommentList(CommentsDTO dto){
		return mapper.selectCommentList(dto);
	}
	
	// 답변 수정
	public int updateComments(int commentsKey, String content) {
		int result = 0;
		try {
			result = mapper.updateComments(commentsKey, content);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//답변 삭제
	public int deleteComments(int commentsKey) {
		int result = 0;
		try {
			result = mapper.deleteComments(commentsKey);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
