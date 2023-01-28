package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.dto.BoardDTO;
import com.shop.dto.CategoryDTO;
import com.shop.dto.CommentsDTO;
import com.shop.dto.Criteria;
import com.shop.dto.ItemDTO;
import com.shop.dto.response.PageResponseDTO;
import com.shop.service.BoardService;
import com.shop.service.CategoryService;
import com.shop.service.ItemService;

//log를 찍어보기위한 Annotation

@Controller
@RequestMapping("/shoplist")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	CategoryService categoryService;

	private final String dir = "shoplist/";
	
	//카테고리 상품 리스트
	@RequestMapping("")
	public String main(@RequestParam(defaultValue="0", value="categoryKey") int categoryKey,
					   @RequestParam(defaultValue="1", value="pageNum") int pageNum,
					   @RequestParam(required = false, defaultValue = "itemKey", value = "order_cri") String order_cri,
					   @RequestParam(required = false, defaultValue = "desc", value = "asc_desc") String asc_desc,
					   Model model, Criteria cri) {

		
		List<ItemDTO> itemList = new ArrayList<>();
		//ItemPageResponseDTO(active, pageNumList, content를 묶어주기 위한 DTO) 선언 및 초기화
		
		
		cri.setOrder_cri(order_cri);
		cri.setCategoryKey(categoryKey);
		cri.setAsc_desc(asc_desc);
		
		PageResponseDTO PageResponseDTO = itemService.getItemPageMaker(cri);
		
		List<CategoryDTO> categoryDTOList = categoryService.get();
		
		itemList = itemService.getItemList(cri);
		
		//itemList 유효성 검사(controller에선 DB에서 접근하지 않는 로직정도만 처리하는게 낫다)
		if(!itemList.isEmpty()) {
			model.addAttribute("itemList", itemList);
		} else {
			model.addAttribute("itemList", "empty");
		}
		
		//model에 변수들 담기
		model.addAttribute("pageNumList", PageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", PageResponseDTO.getPageMaker());
		
		model.addAttribute("categoryList", categoryDTOList);
		
		model.addAttribute("content", dir+"itemlist");
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("categoryKey", categoryKey);
		model.addAttribute("asc_desc", asc_desc);
		model.addAttribute("order_cri", order_cri);
		
		
		//model에 html 파일경로를 value로 담으면 브라우저 url창에선 감춰져 보인다
		return "main";
	}
	
	//상품 상세 페이지 매핑
	@RequestMapping("/product")
	public String product(@RequestParam(required = true, value="itemKey") int itemKey, 
						  HttpSession session, Criteria cri, Model model) {
		
		if(session.getAttribute("custKey")!=null) {
			int custKey = (int) session.getAttribute("custKey");
			model.addAttribute("custKey", custKey);
			ItemDTO itemDTO = itemService.get(itemKey);
			model.addAttribute("content", dir+"product");
			model.addAttribute("item", itemDTO);
		}else {
			
			ItemDTO itemDTO = itemService.get(itemKey);
			model.addAttribute("content", dir+"product");
			model.addAttribute("item", itemDTO);
		}
		
		
		return "main";
	}

	@RequestMapping("/review")
	@ResponseBody
	public Object reviewAjax(@RequestBody String reviewJSON, 
							HttpServletResponse response, ModelMap model){
		
		//뷰단에 받은 데이터를 response의 setContentType으로 utf-8로 변환
		//이 부분이 안되있는 경우, 받은 JSON이 깨져서 들어옴
		response.setContentType("text/html; charset=UTF-8");
		
		JSONObject obj = new JSONObject();
		Criteria cri = new Criteria();
		
		//ObjectMapper의 readValue메소드를 이용해서 내가 받은 JSON을 DTO에 자동으로 파싱 및 매핑을 할수있다
		ObjectMapper mapper = new ObjectMapper();
		
		//후기 리스트
		List<BoardDTO> reviewsList = new ArrayList<>();
		
		
		try {
			//JSON을 Criteria cri로 받음
			cri = (Criteria)mapper.readValue(reviewJSON, new TypeReference<Criteria>() {});
			
			//cri에 amount값 세팅
			cri.setAmount(5);
			
			//받은 cri로 pageDTO 생성 및 pagination 실행
			PageResponseDTO reviewsPageResponseDTO = boardService.getReviewsPageMaker(cri);
			
			//여기서 cri에 skip이 세팅이 안되어있음..
			reviewsList = boardService.getReviewsList(cri);

			
			//TODO 후기가 없을 때 예외 처리해야함, 아래는 후기가 있는 경우 잘 담긴것을 확인
			
			//객체 obj에 후기리스트 담기
			obj.put("reviewsList", reviewsList);
			//객체 obj에 pageNumList 담기
			obj.put("pageNumList", reviewsPageResponseDTO.getPageNumList());
			//객체 obj에 pageMaker(== pageDTO) 담기
			obj.put("pageMaker", reviewsPageResponseDTO.getPageMaker());
			//객체 obj에 Criteria cri 담기
			obj.put("cri", cri);
		} catch (Exception e) {
			System.out.println(e.toString());
			obj.put("res", "error");
		}
		
		return obj;
	}
	
	
	@RequestMapping("/question")
	@ResponseBody
	public Object questionAjax(@RequestBody String questionJSON, 
								HttpServletResponse response, ModelMap model){

		response.setContentType("text/html; charset=UTF-8");

		JSONObject obj = new JSONObject();
		Criteria cri = new Criteria();
		
		ObjectMapper mapper = new ObjectMapper();

		
		//문의 리스트
		List<BoardDTO> questionsList = new ArrayList<>();
		//관리자 답글 리스트
		List<CommentsDTO> commentsList = new ArrayList<>();
		
		
		try {
			cri = (Criteria)mapper.readValue(questionJSON, new TypeReference<Criteria>() {});
			cri.setAmount(5);
			
			PageResponseDTO questionsPageResponseDTO = boardService.getQuestionsPageMaker(cri);
			
			questionsList = boardService.getQuestionsList(cri);

			//TODO 문의가 없을 때 예외 처리해야함
			
			//객체 obj에 후기리스트 담기
			obj.put("questionsList", questionsList);
			//객체 obj에 pageNumList 담기
			obj.put("pageNumList", questionsPageResponseDTO.getPageNumList());
			//객체 obj에 pageMaker(== pageDTO) 담기
			obj.put("pageMaker", questionsPageResponseDTO.getPageMaker());
			//객체 obj에 Criteria cri 담기
			obj.put("cri", cri);
		} catch (Exception e) {
			System.out.println(e.toString());
			obj.put("res", "error");
		}
		
		return obj;
	}


	
}
