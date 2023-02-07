package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.dto.BoardDTO;
import com.shop.dto.CommentsDTO;
import com.shop.dto.Criteria;
import com.shop.dto.response.PageResponseDTO;
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
	
	// 나의 문의 목록 + 페이징
	@RequestMapping("/qnalist")
	public String qnawlist(Model model, Criteria cri, @RequestParam(defaultValue = "1", value = "pageNum") int pageNum , HttpSession session) {
		int custKey = (int)session.getAttribute("custKey");
		cri.setCustKey(custKey);
		
		List<BoardDTO> qnaList = new ArrayList<>();

		PageResponseDTO pageResponseDTO = service.getQuestionsPageMaker(cri);
		
		qnaList = service.getQuestionsList(cri);
	
		if (!qnaList.isEmpty()) {
			model.addAttribute("list", qnaList);
		} 

		// model에 변수들 담기

		model.addAttribute("pageNumList", pageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", pageResponseDTO.getPageMaker());
		model.addAttribute("content", "/board/myqna");
		model.addAttribute("pageNum", pageNum);

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
	
	//나의 후기 리스트 + 페이징
	@RequestMapping("/reviewlist")
	public String reviewlist(Model model, Criteria cri, @RequestParam(defaultValue = "1", value = "pageNum") int pageNum , HttpSession session) {
		int custKey = (int)session.getAttribute("custKey");
		cri.setCustKey(custKey);
		
		List<BoardDTO> reviewList = new ArrayList<>();

		PageResponseDTO pageResponseDTO = service.getReviewsPageMaker(cri);
		
		reviewList = service.getReviewsList(cri);
	
		if (!reviewList.isEmpty()) {
			model.addAttribute("list", reviewList);
		} 

		// model에 변수들 담기

		model.addAttribute("pageNumList", pageResponseDTO.getPageNumList());
		System.out.println(pageResponseDTO);
		System.out.println(pageNum);
		model.addAttribute("pageMaker", pageResponseDTO.getPageMaker());
		model.addAttribute("content", "/board/myreview");
		model.addAttribute("pageNum", pageNum);

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
		System.out.println();

		boardDTO.setCustKey(custKey);
		
		model.addAttribute("boardDTO",boardDTO);
		return "board/writereview";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/reviewJudge")
	@ResponseBody
	public Object reviewJudge(@RequestBody String judgeJSON,  HttpServletResponse response, 
							HttpSession session) {
		
		response.setContentType("text/html; charset=UTF-8");
		
		JSONObject obj = new JSONObject();
		ObjectMapper mapper = new ObjectMapper();
		
		int custKey = (int) session.getAttribute("custKey");
		
		BoardDTO boardDTO = new BoardDTO();
		
		try {
			boardDTO = (BoardDTO) mapper.readValue(judgeJSON, new TypeReference<BoardDTO>() {});
			boardDTO.setCustKey(custKey);
			boolean flag = service.searchedItemKey(boardDTO);
			obj.put("flag", flag);
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("res", "error");
		}
		
		
		return obj;
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
			
			//System.out.println(boardDTO.toString());
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
		boardDTO = service.modifyReview(boardDTO);
		System.out.println(boardDTO.toString());
		
		//model에 담고 html파일명을 return하면 model의 데이터도 이동한다
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
