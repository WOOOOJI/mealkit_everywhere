package com.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admin.dto.BoardDTO;
import com.admin.service.BoardService;
import com.admin.service.CommentsService;
import com.admin.dto.response.ItemPageResponseDTO;
import com.admin.dto.Criteria;
import com.admin.dto.CommentsDTO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService service;

	@Autowired
	CommentsService cservice;

	// 문의목록 + 페이징
	@RequestMapping("/qnalist")
	public String qnalist(Model model, Criteria cri, @RequestParam(defaultValue = "1", value = "pageNum") int pageNum, String type, String keyword) {

		List<BoardDTO> qnaList = new ArrayList<>();
		cri.setKeyword(keyword);
		cri.setType(type);
		ItemPageResponseDTO itemPageResponseDTO = service.getQnaPageMaker(cri);

		qnaList = service.getQnaList(cri);

		if (!qnaList.isEmpty()) {
			model.addAttribute("qnaList", qnaList);
		}

		// model에 변수들 담기
		model.addAttribute("keyword", keyword);
		model.addAttribute("type", type);
		model.addAttribute("pageNumList", itemPageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", itemPageResponseDTO.getPageMaker());
		model.addAttribute("content", "/board/qnalist");
		model.addAttribute("navbar", "/board/navbar");
		model.addAttribute("pageNum", pageNum);

		return "main";
	}

	// 선택한 문의글 삭제(목록에서)
	@ResponseBody
	@PostMapping("/qnadel")
	public int qnaDel(Model model, @RequestParam(value = "delList[]") List<String> delList) {
		int result = 0;
		for (String boardKey : delList) {
			result = service.qnaDel(Integer.parseInt(boardKey));
			;
		}
		model.addAttribute("content", "/board/qnalist");
		model.addAttribute("navbar", "/board/navbar");
		return result;
	}

	// 문의글 + 답변 상세 조회
	@RequestMapping("/qnadetail")
	public String qnadetail(@RequestParam int boardKey, Model model) {
		BoardDTO dto = null; // 초기값 세팅
		CommentsDTO cdto = null;
		try {
			System.out.println("결과값 " + service.qnaDetail(boardKey));

			dto = service.qnaDetail(boardKey);
			cdto = cservice.getreply(boardKey);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("확인용:" + dto);
		System.out.println("cdto확인용:" + cdto);

		model.addAttribute("board", dto); // 문의
		model.addAttribute("replyboard", cdto); // 답변

		model.addAttribute("content", "/board/qnadetail");
		model.addAttribute("navbar", "/board/navbar");
		return "main";

	}

	// 문의글 삭제
	@RequestMapping("/qnaDelete")
	public String qnaDel(int boardKey, Model model) throws Exception {
		int result = service.qnaDelete(boardKey);
		model.addAttribute("result", result);
		return "redirect:/board/qnalist";
	}

	// -----------------------------------------------------------------------

	// 후기목록 + 페이징
	@RequestMapping("/reviewlist")
	public String reviewlist(Model model, Criteria cri,
			@RequestParam(defaultValue = "1", value = "pageNum") int pageNum, String keyword, String type) {

		List<BoardDTO> ReviewList = new ArrayList<>();
		cri.setKeyword(keyword);
		cri.setType(type);
		ItemPageResponseDTO itemPageResponseDTO = service.getReviewPageMaker(cri);

		ReviewList = service.getReviewList(cri);
		System.out.println(ReviewList);
		if (!ReviewList.isEmpty()) {
			model.addAttribute("ReviewList", ReviewList);
		} 

		// model에 변수들 담기
		model.addAttribute("keyword", keyword);
		model.addAttribute("type", type);
		model.addAttribute("pageNumList", itemPageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", itemPageResponseDTO.getPageMaker());
		model.addAttribute("content", "/board/Reviewlist");
		model.addAttribute("navbar", "/board/navbar2");
		model.addAttribute("pageNum", pageNum);

		return "main";
	}

	// 선택한 후기글 삭제(목록에서)
	@ResponseBody
	@PostMapping("/reviewdel")
	public int reviewDel(Model model, @RequestParam(value = "delList[]") List<String> delList) {
		int result = 0;
		for (String boardKey : delList) {
			result = service.reviewDel(Integer.parseInt(boardKey));
			;
		}
		model.addAttribute("content", "/board/reviewlist");
		model.addAttribute("navbar", "/board/navbar2");
		return result;
	}

	// 후기글 상세 조회
	@RequestMapping("/reviewdetail")
	public String reviewdetail(@RequestParam int boardKey, Model model) {
		BoardDTO dto = null; // 초기값 세팅

		try {
			System.out.println("결과값 " + service.reviewDetail(boardKey));

			dto = service.reviewDetail(boardKey);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("확인용:" + dto);

		model.addAttribute("board", dto); // 문의

		model.addAttribute("content", "/board/reviewdetail");
		model.addAttribute("navbar", "/board/navbar2");
		return "main";

	}

	// 후기글 삭제
	@RequestMapping("/reviewDelete")
	public String reviewDel(int boardKey, Model model) throws Exception {
		int result = service.reviewDelete(boardKey);
		model.addAttribute("result", result);
		return "redirect:/board/reviewlist";
	}

	// -------------------------------------------------------------------------

}
