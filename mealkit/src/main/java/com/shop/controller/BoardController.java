package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dto.BoardDTO;
import com.shop.dto.CommentsDTO;
import com.shop.dto.CustomerDTO;
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
		
		int cust_key = (int)session.getAttribute("cust_key");
		
		List<BoardDTO> qnaList = new ArrayList<BoardDTO>();
		try {
			qnaList = service.qnaList(cust_key);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------------------------");
		}
		                           
		
		  model.addAttribute("list", qnaList); 
		  model.addAttribute("content",
		  "/board/myqna");
		 
		
		return "main";
}

	
	// 나의 문의 상세보기 + 문의에 달린 관리자 답변
	@RequestMapping("/qnadetail")
	public String qnadetail (@RequestParam int board_key, Model model) {
		ModelAndView mav = new ModelAndView();
		
		try {
			mav.addObject("dto", service.get(board_key));
		} catch (Exception e) {		
			e.printStackTrace();			
		}		
		BoardDTO dto = null; //초기값 세팅
		CommentsDTO cdto = null; 
		try {
			System.out.println("결과값 " + service.get(board_key));
			System.out.println("결과값 " + cservice.getreply(board_key));
			 dto = service.get(board_key);
			 cdto = cservice.getreply(board_key);
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
		
		int cust_key = (int)session.getAttribute("cust_key");
		
		List<BoardDTO> reviewList = new ArrayList<BoardDTO>();
		try {
			reviewList = service.reviewList(cust_key);
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
	public String reviewdetail (@RequestParam int board_key, Model model) {
		ModelAndView mav = new ModelAndView();
		
		try {
			mav.addObject("dto", service.reviewDetail(board_key));
		} catch (Exception e) {		
			e.printStackTrace();			
		}		
		BoardDTO dto = null; //초기값 세팅
		try {
			System.out.println("결과값 " + service.reviewDetail(board_key));
			
			 dto = service.reviewDetail(board_key);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("board", dto);
		model.addAttribute("content", "/board/reviewdetail");
		return "main";

	}
	
	
	
	// 후기글 삭제
	@RequestMapping("/boardDel")
    public String boardDel(int board_key, Model model) throws Exception {
        int result = service.reviewDel(board_key);
        model.addAttribute("result", result);
        return "redirect:/board/reviewlist";
    }
	
	
}
