package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dto.BoardDTO;
import com.shop.dto.CommentsDTO;
import com.shop.service.BoardService;
import com.shop.service.CommentsService;

@Controller
@RequestMapping("/board")
public class BoardController {
	

	@Autowired
	BoardService service;

	
	@Autowired
	CommentsService cservice;
	
	
	// 나의 문의 목록
	@RequestMapping("/qnalist") 
	public String qnalist (Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		int custKey = (int)session.getAttribute("custKey");
		
		List<BoardDTO> qnaList = new ArrayList<BoardDTO>();
		try {
			qnaList = service.qnaList(custKey);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------------------------");
		}
		                           
		
		  model.addAttribute("list", qnaList); 
		  model.addAttribute("content", "/board/myqna");
		 
		
		return "main";
}

	
	// 나의 문의 상세보기 + 문의에 달린 관리자 답변
	@RequestMapping("/qnadetail")
	public String qnadetail (@RequestParam int boardKey, Model model) {
		ModelAndView mav = new ModelAndView();
		
		try {
			mav.addObject("dto", service.get(boardKey));
		} catch (Exception e) {		
			e.printStackTrace();			
		}		
		BoardDTO dto = null; //초기값 세팅
		CommentsDTO cdto = null; 
		try {
			System.out.println("결과값 " + service.get(boardKey));
			System.out.println("결과값 " + cservice.getreply(boardKey));
			 dto = service.get(boardKey);
			 cdto = cservice.getreply(boardKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("확인용:"+dto);
		
		model.addAttribute("replyboard", cdto); //답변
		
		
		model.addAttribute("board", dto); //문의
		model.addAttribute("content", "/board/qnadetail");
		return "main";

	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	
	// 나의 후기 목록 
	@RequestMapping("/reviewlist") 
	public String reviewlist(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		int custKey = (int)session.getAttribute("custKey");
		
		List<BoardDTO> reviewList = new ArrayList<BoardDTO>();
		try {
			reviewList = service.reviewList(custKey);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------------------------");
		}
	             
		model.addAttribute("list", reviewList);							 
		model.addAttribute("content", "/board/myreview");
		
		return "main";
	}
	
	
	// 나의 후기 상세보기
	@RequestMapping("/reviewdetail")
	public String reviewdetail (@RequestParam int boardKey, Model model) {
		ModelAndView mav = new ModelAndView();
		
		try {
			mav.addObject("dto", service.reviewDetail(boardKey));
		} catch (Exception e) {		
			e.printStackTrace();			
		}		
		BoardDTO dto = null; //초기값 세팅
		try {
			System.out.println("결과값 " + service.reviewDetail(boardKey));
			
			 dto = service.reviewDetail(boardKey);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("board", dto);
		model.addAttribute("content", "/board/reviewdetail");
		return "main";

	}
	
	
	
	// 후기글 삭제
	@RequestMapping("/boardDel")
    public String boardDel(int boardKey, Model model) throws Exception {
        int result = service.reviewDel(boardKey);
        model.addAttribute("result", result);
        return "redirect:/board/reviewlist";
    }
	
	//문의글 삭제 + 답변 삭제 (DDL문에서 on delete cascade추가해서 답변까지 함께 지울 수 있도록 함) 
	@RequestMapping("/qnaDel")
	public String qnaDel(int boardKey, Model model) throws Exception{
		int result = service.qnaDel(boardKey);
		model.addAttribute("result", result);
		return "redirect:/board/qnalist";
			
		}
	
	
	
	
	
	// 후기글 수정폼
	@RequestMapping("/boardEdit")
	public String boardEdit(int boardKey, Model model) {
		BoardDTO dto = null;
		try {
			dto = service.reviewDetail(boardKey);
		} catch (Exception e) {
			System.out.println("Error Caused by BoardController at row 171");
			e.printStackTrace();
		}
		
		
		model.addAttribute("content", "board/revieweditform");
		model.addAttribute("board", dto);
		
		
		return "main";
	}
	
	
	
	
	// 후기글 수정
	@PostMapping("/boardEditOk")
	@ResponseBody
	public int boardEditOk(int boardKey, String content, Model model) {
		int result = 0;
	
		result = service.boardEdit(boardKey, content);
		
		return result;
	}
	
	
	
	// 문의글 수정폼
	@RequestMapping("/qnaEdit")
	public String qnaEdit(int boardKey, Model model) {
		BoardDTO dto = null;
		try {
			dto = service.get(boardKey);
		} catch (Exception e) {
			System.out.println("Error Caused by BoardController at row 208");
			e.printStackTrace();
		}
		
		
		model.addAttribute("content", "board/qnaeditform");
		model.addAttribute("board", dto);
		
		
		return "main";
	}
	
	
	
	
	// 문의글 수정
	@PostMapping("/qnaEditOk")
	@ResponseBody
	public int qnaEditOk(int boardKey, String content, Model model) {
		int result = 0;
	
		result = service.boardEdit(boardKey, content);
		
		return result;
	}
	
	
	
	
}
