package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admin.dto.BoardDTO;
import com.admin.dto.CommentsDTO;
import com.admin.service.BoardService;
import com.admin.service.CommentsService;

@Controller
@RequestMapping("/comments")
public class CommentsController {
	
	@Autowired
	CommentsService cservice;
	
	@Autowired
	BoardService bservice;
	
	// 답글 등록
	@GetMapping("/replyBoardWrite")
	public String replyWrite(int boardKey, String content) {
		cservice.insertComments(boardKey, content);
		String redirectUrl = "redirect:/board/qnadetail?boardKey="+Integer.toString(boardKey);
		return redirectUrl;
	}
	
	// 답글 불러오기
	@GetMapping("/getCommentList")
	@ResponseBody
	private List<CommentsDTO> getCommentList(int boardKey) throws Exception{
		CommentsDTO dto = new CommentsDTO();
		dto.setBoardKey(boardKey);
		return cservice.getCommentList(dto);
	}
	
	// 답글 수정폼으로 보내기
	@RequestMapping("/replyBoardEditForm")
	public String replyEditForm(CommentsDTO commentsdto, BoardDTO boarddto,  Model model) {

		try {
			 boarddto = bservice.qnaDetail(boarddto.getBoardKey());
			 commentsdto = cservice.getreply(boarddto.getBoardKey());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("boardKey", boarddto.getBoardKey());
		model.addAttribute("commentsKey", commentsdto.getCommentsKey());
		model.addAttribute("chk", 1);
		model.addAttribute("replycontent", commentsdto.getContent());
		
		model.addAttribute("content", "/board/qnadetail");
		model.addAttribute("navbar", "/board/navbar");

		model.addAttribute("board", boarddto); //문의
		model.addAttribute("replyboard", commentsdto); //답변
		
		return "main";
	}
	
	// 답글 수정 
	@RequestMapping("/replyBoardEdit")
	public String replyEdit( Model model, CommentsDTO commentsdto, BoardDTO boarddto ) {
		cservice.updateComments(commentsdto.getCommentsKey(),commentsdto.getContent());

		try {
			 boarddto = bservice.qnaDetail(boarddto.getBoardKey());
			 commentsdto = cservice.getreply(boarddto.getBoardKey());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("boardKey", boarddto.getBoardKey());
		model.addAttribute("commentsKey", commentsdto.getCommentsKey());
		model.addAttribute("replycontent", commentsdto.getContent());
		
		model.addAttribute("content", "/board/qnadetail");
		model.addAttribute("navbar", "/board/navbar");
		
		model.addAttribute("board", boarddto); //문의
		model.addAttribute("replyboard", commentsdto); //답변
		model.addAttribute("chk", 0);
		return "main";
	}
		
	
	// 답글 삭제
	@RequestMapping("/replyBoardDelete")
	public String replyDelete(int boardKey, int commentsKey, Model model) { 
		int result = cservice.deleteComments(commentsKey); 
		System.out.println(commentsKey);
		model.addAttribute("comments", result); 
		model.addAttribute("content", "/board/qnadetail");
		model.addAttribute("navbar", "/board/navbar"); 
		String redirectUrl = "redirect:/board/qnadetail?boardKey="+Integer.toString(boardKey);
		return redirectUrl;
	}
}
