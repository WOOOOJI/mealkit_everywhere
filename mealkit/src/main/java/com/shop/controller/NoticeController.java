package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.dto.Criteria;
import com.shop.dto.NoticeDTO;
import com.shop.dto.response.ItemPageResponseDTO;
import com.shop.service.NoticeService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class NoticeController {
	
	// notice관련 기본 파일 dir
	String dir = "board/";
	
	@Autowired
	NoticeService noticeService;
	
	
	// 회사소개 페이지로 이동
	@RequestMapping("/about")
	public String aboutPage(Model model) {
		model.addAttribute("content", "board/about");
		return "main";
	}	

	
	// 이벤트 페이지로 이동
	@RequestMapping("/event")
	public String eventPage(Model model, Criteria cri, @RequestParam(defaultValue="1", value="pageNum") int pageNum) {

		log.info("NoticeController 33th line, Criteria "+cri);
		
		
		// 이벤트 페이지 리스트를 받아올 arrayList 인스턴스 생성
		List<NoticeDTO> eventList = new ArrayList<>();
		
		//ItemPageResponseDTO(active, pageNumList, content를 묶어주기 위한 DTO) 선언 및 초기화
		ItemPageResponseDTO itemPageResponseDTO = noticeService.getEventPageMaker(cri);
		
		eventList = noticeService.getEventList(cri);
		
		// 가져온 이벤트 페이지가 없다면, empty로 담아준다.
		// 만약에 있다면 받아온 객체를 넣어준다.
		if(!eventList.isEmpty()) {
			model.addAttribute("eventList", eventList);
		} else {
			model.addAttribute("eventList", "empty");
		}
		
		// 페이징 관련 변수들 모두 담아주기.
		model.addAttribute("pageNumList", itemPageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", itemPageResponseDTO.getPageMaker());		
		model.addAttribute("content", dir+"event");
		model.addAttribute("pageNum", pageNum);
		
		
		//model에 html 파일경로를 value로 담으면 브라우저 url창에선 감춰져 보인다
		return "main";
	}
	
	
	
	
	
	
	// 선택한 이벤트 상세 페이지로 접속
	@RequestMapping("/event/detail")
	public String eventDeatilPage(Model model, int notice_key) {
		
		// 하나의 상세 페이지에 대한 정보를 담을 dto 생성과 초기화
		NoticeDTO dto = noticeService.eventDetail(notice_key);
		
		// 또한 접속을 요청할때마다 조회수가 1씩 증가를 한다.
		noticeService.noticeHit(notice_key);
		
		// 받은 dto의 정보를 뷰에 뿌려준다.
		model.addAttribute("notice", dto);
		model.addAttribute("content", "board/eventdetail");
		return "main";
	}
	

	
	
	
	// 이벤트 리스트 페이지와 작동원리 동일
	// 공지사항 리스트 페이지로 이동
	@RequestMapping("/notice")
	public String noticePage(Model model, Criteria cri, @RequestParam(defaultValue="1", value="pageNum") int pageNum) {

		log.info("NoticeController 33th line, Criteria "+cri);
		
		List<NoticeDTO> noticeList = new ArrayList<>();
		//ItemPageResponseDTO(active, pageNumList, content를 묶어주기 위한 DTO) 선언 및 초기화
		ItemPageResponseDTO itemPageResponseDTO = noticeService.getNoticePageMaker(cri);
		
		noticeList = noticeService.getNoticeList(cri);
		
		//
		if(!noticeList.isEmpty()) {
			model.addAttribute("noticeList", noticeList);
		} else {
			model.addAttribute("itemList", "empty");
		}
		
		//
		log.info("itemController 34th line, active "+itemPageResponseDTO.getActive());
		model.addAttribute("active", itemPageResponseDTO.getActive());
		model.addAttribute("pageNumList", itemPageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", itemPageResponseDTO.getPageMaker());		
		model.addAttribute("content", dir+"notice");
		model.addAttribute("pageNum", pageNum);
		
		//
		return "main";
	}
	
	
	
	
	// 이벤트 상세 페이지와 작동원리 동일
	// 선택한 공지사항 상세 페이지로 이동
	@RequestMapping("/notice/detail")
	public String noticeDeatilPage(Model model, int notice_key) {
		NoticeDTO dto = noticeService.eventDetail(notice_key);
		
		noticeService.noticeHit(notice_key);
		model.addAttribute("notice", dto);
		model.addAttribute("content", "board/noticedetail");
		return "main";
	}
}
