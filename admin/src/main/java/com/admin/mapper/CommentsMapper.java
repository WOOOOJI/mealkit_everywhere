package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.CommentsDTO;
import com.admin.frame.MyMapper;

@Mapper
@Repository
public interface CommentsMapper extends MyMapper<Integer, CommentsDTO>{
	//관리자 답변 보기
	public CommentsDTO qnaReply(int boardKey) throws Exception; 
	
//-----------------------------------------------------	
	
	//답글 등록
	public int insertComments(int boardKey, String content);
	
	//답글 조회
	public List<CommentsDTO> selectCommentList(CommentsDTO dto);
	
	//답글 수정
	public int updateComments(int commentsKey, String content);
	
	//답글 삭제
	public int deleteComments(int commentsKey);
}
