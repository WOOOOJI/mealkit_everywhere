package com.admin.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.admin.dto.PageDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
//데이터들을 묶어서 컨트롤러로 전달하기 위한 DTO
public class PageResponseDTO {
	
	private PageDTO pageMaker;
	
	private List<Integer> pageNumList = new ArrayList<>();
	
	private int active;
}
