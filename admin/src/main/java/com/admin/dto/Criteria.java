package com.admin.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

  @Setter
  @Getter
  @ToString
  //페이지 번호, 개수, 스킵을 세팅하기 위한 클래스
  public class Criteria {

	  //현재 페이지 번호
	  private int pageNum;

	  //한 페이지에 출력할 데이터 개수
	  private int amount;

	  //페이지 스킵
	  private int skip;

	  //검색 키워드
	  private String keyword;

	  //검색 타입
	  private String type;

	  //카테고리 번호
	  private int categoryKey;

	  //게시글 타입(공지사항/이벤트)
	  private String ntype;


	  private String orderBy;

	  //이메일 검색 키워드
	  private String emailKeyword;

	  //이름 검색 키워드
	  private String nameKeyword;

	  //전화번호 검색 키워드
	  private String phNumberKeyword;

	  //정렬 기준
	  private String orderCri;

	  //차순
	  private String ascDesc = "desc";



	  //디폴트값을 설정하는 기본 생성자 
	  public Criteria() { 
		 this.pageNum = 1;
		 this.amount = 12;
	  }


	  public Criteria(int pageNum, int amount) {
		  this.pageNum = pageNum;
		  this.amount = amount;
		  this.skip = (pageNum - 1) * amount;
	  }

	  //검색 타입 데이터 배열 변환
	  public String[] getTypeArr() {
		  return type == null ? new String[] {} : type.split("");
	  }

	  //페이지 번호 세팅과 스킵 세팅
	  public void setPageNum(int pageNum) {
		  this.pageNum = pageNum;
		  this.skip = (pageNum -1 ) * this.amount;
	  }

	  //데이터 개수 세팅과 스킵 세팅
	  public void setAmount(int amount) {
		  this.amount = amount;
		  this.skip = (this.pageNum - 1) * amount;
	  }


  }
