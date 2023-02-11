package com.admin.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.dto.Criteria;
import com.admin.dto.NoticeDTO;
import com.admin.dto.response.PageResponseDTO;
import com.admin.frame.fileRename;
import com.admin.service.NoticeService;



@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	@Value("${noticedir}")
	String noticedir;

	String dir = "notice/";

	@RequestMapping("")
	public String main(@RequestParam(defaultValue = "1", value = "pageNum") int pageNum,
			@RequestParam(defaultValue = "none", value = "ntype") String ntype,
			@RequestParam(defaultValue = "DESC", value = "ascDesc") String ascDesc,
			@RequestParam(defaultValue = "noticeKey", value = "orderCri") String orderCri,
			@RequestParam(defaultValue = "none", value = "keyword") String keyword,
			@RequestParam(defaultValue = "name", value = "type") String type,
			Model model, HttpSession session,  Criteria cri) {


		List<NoticeDTO> noticeList = null;


		cri.setAscDesc(ascDesc);
		cri.setOrderCri(orderCri);
		cri.setNtype(ntype);
		cri.setKeyword(keyword);
		cri.setType(type);
		PageResponseDTO pageResponseDTO = noticeService.getNoticePageMaker(cri);
		noticeList = noticeService.getNoticeList(cri);

		// 페이징 관련 변수들 모두 담아주기.
		model.addAttribute("type", type);
		model.addAttribute("ntype", ntype);
		model.addAttribute("ascDesc",ascDesc);
		model.addAttribute("orderCri",orderCri);
		model.addAttribute("pageNumList", pageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", pageResponseDTO.getPageMaker());
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", noticeList);
		model.addAttribute("content", dir + "noticelist");
		return "main";
	}

	@RequestMapping("/registerform")
	public String register(Model model, HttpSession session) {
		int adminKey=(int)session.getAttribute("adminKey");
		String name=(String)session.getAttribute("name");

		model.addAttribute("adminKey",adminKey);
		model.addAttribute("name",name);
		model.addAttribute("content", dir + "registerform");
		return "main";
	}

	@RequestMapping("/register")
	public String register(NoticeDTO notice, Model model, HttpSession session) {
		// view에서 받아온 item의 img의 이름들을 저장
		String img1 = notice.getImgFile1().getOriginalFilename();
		String img2 = notice.getImgFile2().getOriginalFilename();

		try {
			// 이름이 없으면 파일을 첨부하지 않았으니 실행 안함
			if (!img1.equals("") && img1 != null) {
				// File 객체를 생성하여 path와 파일명을 설정
				File saveFile1 = new File(noticedir + img1);
				// 그 곳에 같은 이름이 있으면 fileRename객체 호출하여 이름 다시 작성 (com.admin.frame)
				saveFile1 = new fileRename().rename(saveFile1);
				// item객체의 img의 이름을 설정하여 나중에 불러올 수 있게 설정
				notice.setImg1(saveFile1.getName());
				// 실제 파일 저장
				notice.getImgFile1().transferTo(saveFile1);
			}
			if (!img2.equals("") && img2 != null) {
				File saveFile2 = new File(noticedir + img2);
				saveFile2 = new fileRename().rename(saveFile2);
				notice.setImg2(saveFile2.getName());
				notice.getImgFile2().transferTo(saveFile2);
			}

			noticeService.registerNotice(notice);
			model.addAttribute("content", dir + "registerok");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("content", dir + "registerfail");
		}
		
		return "main";
	}

	@RequestMapping("/noticedetail")
	public String detail(int noticeKey, Model model, HttpSession session) {

		NoticeDTO notice = null;
		notice = noticeService.get(noticeKey);
		int adminKey=(int)session.getAttribute("adminKey");
		String name=(String)session.getAttribute("name");

		model.addAttribute("noticedir", noticedir);
		model.addAttribute("adminKey",adminKey);
		model.addAttribute("name",name);
		model.addAttribute("notice", notice);
		model.addAttribute("content", dir + "noticedetail");
		return "main";
	}

	@RequestMapping("/update")
	public String update(NoticeDTO notice, Model model, HttpSession session) {
		// view에서 받아온 item의 img의 이름들을 저장
		String img1="";
		String img2="";
		//파일 업로드가 안되면
		if(notice.getImgFile1()==null) {
			img1=notice.getImg1();
		}else {
			img1 = notice.getImgFile1().getOriginalFilename();
		}

		if(notice.getImgFile2()==null) {
			img2 = notice.getImg2();
		}else {
			img2 = notice.getImgFile2().getOriginalFilename();
		}

		try {
			// 이름이 없으면 파일을 첨부하지 않았으니 실행 안함
			if (!img1.equals("") && img1 != null&&notice.getImgFile1()!=null) {
				// File 객체를 생성하여 path와 파일명을 설정
				File saveFile1 = new File(noticedir + img1);
				// 그 곳에 같은 이름이 있으면 fileRename객체 호출하여 이름 다시 작성 (com.admin.frame)
				saveFile1 = new fileRename().rename(saveFile1);
				// item객체의 img의 이름을 설정하여 나중에 불러올 수 있게 설정
				notice.setImg1(saveFile1.getName());
				// 실제 파일 저장
				notice.getImgFile1().transferTo(saveFile1);
			}
			if (!img2.equals("") && img2 != null&&notice.getImgFile2()!=null) {
				File saveFile2 = new File(noticedir + img2);
				saveFile2 = new fileRename().rename(saveFile2);
				notice.setImg2(saveFile2.getName());
				notice.getImgFile2().transferTo(saveFile2);
			}



			noticeService.modify(notice);
			model.addAttribute("content", dir + "registerok");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("content", dir + "registerfail");
		}

		return "main";
	}

	@RequestMapping("/delete")
	public String delete(int noticeKey, Model model, HttpSession session) {
		noticeService.remove(noticeKey);
		return "redirect:/notice";
	}
}
