package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.dto.BoardDTO;
import com.shop.dto.CommentsDTO;
import com.shop.dto.ItemDTO;
import com.shop.service.BoardService;
import com.shop.service.CommentsService;
import com.shop.service.ItemService;

@Controller
@RequestMapping("/board")
public class BoardController {
	

	@Autowired
	BoardService service;

	
	@Autowired
	CommentsService cservice;
	
	@Autowired
	ItemService itemService;
	
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
		  model.addAttribute("content",
		  "/board/myqna");
		 
		
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

	
	//후기 작성 폼으로 넘어가는 메소드
	@RequestMapping("/writeReview")
	public String writeReview(BoardDTO boardDTO, HttpSession session , Model model) {
		
		int custKey = (int) session.getAttribute("custKey");

		boardDTO.setCustKey(custKey);
		System.out.println(boardDTO.toString());
		
		model.addAttribute("boardDTO",boardDTO);
		return "board/writereview";
	}
	
	//후기 작성 폼에서 후기 등록하는 메소드 
	@RequestMapping("/registerReview")
	@ResponseBody
	public int registerReview(@RequestBody String reviewJSON,
								 HttpServletResponse response, Model model) {
		int result = 0;
		
		response.setContentType("text/html; charset=UTF-8");
		
		BoardDTO boardDTO = new BoardDTO();
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			boardDTO = (BoardDTO)mapper.readValue(reviewJSON, new TypeReference<BoardDTO>() {});
			
			System.out.println(boardDTO.toString());
			service.register(boardDTO);
			
			result = 1;
		} catch (Exception e) {
			System.out.println("후기 등록 실패");
			System.out.println(e.toString());
		}
		
		
		return result;
	}
	
	
	
	//후기 수정 폼으로 넘어가는 메소드
	@RequestMapping("/modReview")
	public String modReview(BoardDTO boardDTO, HttpSession session , Model model) {
		
		int custKey = (int) session.getAttribute("custKey");

		boardDTO.setCustKey(custKey);
		System.out.println(boardDTO.toString());
			
		model.addAttribute("boardDTO",boardDTO);
		return "board/modreview";
	}
		
	//후기 수정 폼에서 후기 업데이트하는 메소드 
	@RequestMapping("/updateReview")
	@ResponseBody
	public int updateReview(@RequestBody String reviewJSON,
							 HttpServletResponse response, Model model) {
		int result = 0;
		
		response.setContentType("text/html; charset=UTF-8");
			
		BoardDTO boardDTO = new BoardDTO();
			
		ObjectMapper mapper = new ObjectMapper();
			
		try {
			boardDTO = (BoardDTO)mapper.readValue(reviewJSON, new TypeReference<BoardDTO>() {});
				
			System.out.println(boardDTO.toString());
			service.modify(boardDTO);
				
			result = 1;
		} catch (Exception e) {
			System.out.println("후기 등록 실패");
			System.out.println(e.toString());
		}
			
		return result;
	}
	
	//문의 작성 폼으로 넘어가는 메소드
	@RequestMapping("/writeQuestion")
	public String writeQuestion(BoardDTO boardDTO, HttpSession session , Model model) {
			
		int custKey = (int) session.getAttribute("custKey");

		boardDTO.setCustKey(custKey);
		System.out.println(boardDTO.toString());
			
		model.addAttribute("boardDTO",boardDTO);
		return "board/writequestion";
	}
		
		
	//문의 작성 폼에서 문의 등록하는 메소드 
	@RequestMapping("/registerQuestion")
	@ResponseBody
	public int registerQuestion(@RequestBody String questionJSON,
								 HttpServletResponse response, Model model) {
		int result = 0;
			
		response.setContentType("text/html; charset=UTF-8");
			
		BoardDTO boardDTO = new BoardDTO();
			
		ObjectMapper mapper = new ObjectMapper();
			
		try {
			boardDTO = (BoardDTO)mapper.readValue(questionJSON, new TypeReference<BoardDTO>() {});
				
			System.out.println(boardDTO.toString());
			service.register(boardDTO);
				
			result = 1;
		} catch (Exception e) {
			System.out.println("문의 등록 실패");
			System.out.println(e.toString());
		}
			
			
		return result;
	}
	
	//문의 수정 폼으로 넘어가는 메소드
	@RequestMapping("/modQuestion")
	public String modQuestion(BoardDTO boardDTO, HttpSession session , Model model) {
			
		int custKey = (int) session.getAttribute("custKey");

		boardDTO.setCustKey(custKey);
		System.out.println("boardController, 302th line, At modQuestion " + boardDTO.toString());
				
		model.addAttribute("boardDTO",boardDTO);
		return "board/modquestion";
	}
			
	//후기 수정 폼에서 후기 업데이트하는 메소드 
	@RequestMapping("/updateQuestion")
	@ResponseBody
	public int updateQuestion(@RequestBody String questionJSON,
							 HttpServletResponse response, Model model) {
		int result = 0;
			
		response.setContentType("text/html; charset=UTF-8");
				
		BoardDTO boardDTO = new BoardDTO();
				
		ObjectMapper mapper = new ObjectMapper();
				
		try {
			boardDTO = (BoardDTO)mapper.readValue(questionJSON, new TypeReference<BoardDTO>() {});
					
			System.out.println("boardController, 324th line, At updateQuestion " + boardDTO.toString());
			service.modify(boardDTO);
					
			result = 1;
		} catch (Exception e) {
			System.out.println("후기 등록 실패");
			System.out.println(e.toString());
		}
				
		return result;
	}
}
