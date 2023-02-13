# Mealkit-Everywhere🍲
팀장: 김기태  팀원: 연우진, 이상아, 한승우  
기간: 2023.01.06~2023.02.17  
🔗[웹 페이지 시연영상](https://youtu.be/zLp9kFtKYJY)  
🔗[노션 링크](https://www.notion.so/246758c62a5b4e728cd50f89d021ba07?v=78f471175d4a49ea93b0195f26fa602a&pvs=4)

## 1. 프로젝트 주제 및 기획의도
- **주제**:
AJAX를 이용한 실시간 통계 기능과 Clova Chatbot을 활용한 1:1 문의 시스템을 활용한
Spring boot 기반의 밀키트 쇼핑 웹 서비스 개발

- #### 기획의도  - 소상공인 타겟 => 통계기능 쉽게 설정해서 볼 수 있고 + 챗봇이용해서 문의 처리 효율화 + 소비자 페이지, 관리자 페이지 연동을 통해 쉽게 사이트 관리 
1. 통계 기능을 통해 판매 동향 파악 및 분석 가능    
2. 반응형 웹 서비스와  네이버 클라우드 플랫폼에서 제공하는 AI Service, 카카오 api를 활용하며 기존의 사이트와 차별화  
3. 소비자 페이지와 관리자 페이지 별도 개발, 페이지 간 적절히 연동
4. 사용자의 편의를 고려한 화면구성과 기능 구현
5. 

## 2. 프로젝트 수행 방법 및 도구 
✨**프로젝트 계획도**  
<img width="989" alt="프로젝트 계획도" src="https://user-images.githubusercontent.com/117332944/218390432-91c94118-fad4-4998-9cf3-554b3b8a4df5.png">  
✨**USER-FLOW**  
![밀키트_user_flow](https://user-images.githubusercontent.com/117332944/218390528-75983d08-d9a3-41ad-9954-17bef1dcfb92.jpg)  

✨**ADMIN-FLOW**  
![밀키트_admin_flow](https://user-images.githubusercontent.com/117332944/218390592-3a0826d6-6212-4bc6-9ad4-2b79a6a3355a.JPG)  

✨**DB 설계**  
![밀키트 쇼핑몰](https://user-images.githubusercontent.com/117332944/218390373-5adad535-a5d4-4bc9-b045-55fd67321956.png)  

✨**WBS**  
**🔗[WBS 보러가기](https://docs.google.com/spreadsheets/d/189ZZKjUHNqMd7KinS7MKgbGLZvjOy8vEU_ur2jmIbVE/edit?usp=sharing)**  
![WBS 전체](https://user-images.githubusercontent.com/117332944/218392819-b108f8a0-4beb-405a-ba30-4071181179bb.png)  
<br>
✨**시스템 구성도**  
![시스템구성도](https://user-images.githubusercontent.com/117332944/218389295-69752ce4-0cea-41aa-8719-5280226453c6.png)  


✨**개발 환경 및 수행 도구**  
|개발도구|협업도구|언어|DB|프레임워크|API|SERVER|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|Eclipse 2020-12|Github<br>Zoom<br>ERD Cloud<br>Google Docs|Java<br>JavaScript<br>HTML5<br>CSS3<br>SQL<br>AJAX|MySQL 8.0|Spring Boot 2.77<br>MyBatis<br>Thymeleaf|카카오 로그인<br>스마트 택배<br>아임포트(I'mport)<br>카카오 우편번호<br>Naver Chatbot|Tomcat 9.0<br>NCP(Naver Cloud Platform)|




## 3. 프로젝트 역할분담

|이름|역할|
|--|--| 
|김기태|상품 리스트 페이지 구현<br>게시판 페이지네이션 구현<br>상품 상세 페이지 구현<br>문의 - 후기 게시판(CRUD) 구현<br>챗봇 API 및 WebSocket을 이용한 문의 처리 구현<br>관리자 회원관리 게시판(조회, 차단 설정) 구현<br>관리자 통계 기능 구현(전일 대비 판매 차트 구현, TOP-WORST10 상품리스트 구현)|  
|연우진|NCP에 서버 전개 및 DB(Replication) 설치<br>AI ChatBot, WebSocket을 활용한 사용자 문의처리 및 간편이용 시스템 개발.<br>관리자 페이지에서의 실시간 차트 및 통계 차트 관련 기능/주문 관리기능 개발.<br>사용자 페이지에서의 장바구니 기능 및 배송API를 활용한 배송조회 기능 개발.<br>관리자, 사용자 메인화면(View) 설계.|
|이상아|회원가입 및 로그인 관련 기능 구현<br>카카오 API를 이용한 소셜로그인 구현<br>인터셉터(Interceptor) 구현<br>마이페이지 구현<br>Spring Security를 이용한 Bcrypt 암호화 작업<br>관리자 페이지 문의/후기/답변 관리 구현<br>관리자 페이지 통계 기능 구현<br>(년도/월/일별 통계-화면 구성, 상세검색-배송량, 판매액, 판매된 제품 수, 구매확정)|
|한승우|아임포트(I'mport)을 활용한 결제 기능 구현<br>주문 관련 기능 구현<br>카카오 우편번호 API를 이용한 검색 기능 구현<br>사용자 배송지 선택,생성,삭제 및 기본배송지 설정 구현<br>장바구니, 배송지와 주문 연동 구현<br>Spring Security를 이용한 Bcrypt 암호화 작업<br>나의 주문리스트 페이지 구현<br>주문 상세 페이지 구현<br>관리자 페이지 상품,공지/이벤트 관리(CRUD) 및 이미지 파일 관련 기능 구현<br>관리자 페이지 실시간 통계 기능 구현<br>(매출차트,내아디별/성별 판매비율, 카테고리별 판매비율,주문당 평균)|
  

## 4. 프로젝트 구현 기능

✨**핵심 기능**  

<img width="187" alt="ufav" src="https://user-images.githubusercontent.com/111713782/207254283-b01c1f9c-d3ac-4953-acb9-c0c8ffc0ef82.PNG">



✨**사용자 페이지**  
**1) 챗봇(Chatbot)**  
- 내용쓰자....
- 내용내용
- 내용ㅇ
- 
**2) 주문/결제(I'm port)**  
- 내용내용내용
→
→
→

**3) sns로그인(kakao) **  
- SNS계정으로 처음 로그인을 하는 경우, 카카오 서버는 redirect url로 인증코드를 전달   
  → 클라이언트(Web)쪽에서 인증코드를 이용하여  access_token발급받은 후 서버로 전송   
  → 서버에서는 access_token을 이용하여 카카오 서버로부터 사용자 정보(이름, 이메일, 성별)를 받음   
  → 사용자정보를 db에 저장함으로서 회원가입 진행한 후 로그인되도록 구현
  
  

<br>

**4) 상품 상세**  
- 상품에 해당하는 전체 후기의 평균 평점 출력 / 장바구니와 찜 기능  
- AJAX를 활용한 후기 게시판 (구매자만 작성 가능, CRUD, 관리자 댓글 조회)  
- AJAX를 활용한 문의 게시판 (CRUD, 관리자 댓글 조회)   
![2](https://user-images.githubusercontent.com/114971312/218420140-1a125f97-4c76-419a-910f-8c8ca350edaa.JPG)
![1](https://user-images.githubusercontent.com/114971312/218420151-7d59a6c8-c2db-4473-826a-d1c7a2eb5304.JPG)
![3](https://user-images.githubusercontent.com/114971312/218420177-53d978dd-73ec-44e6-9e9b-c39edbc7b613.JPG)





**5) 배송 조회 (스마트택배 API)**  
- 내용내용 
- 내용내용 
- 내용내용 


**6) 다음 우편번호 API**  


✨**관리자 페이지**
**1) 실시간 통계**  



**2) 년도/월/일별 통계**  



**3) 통계 상세 검색**  




✨**기타 **  
**1) 로드밸런서**  
-내용내용
-내용내용


**2) 암호화(Bcrypt)**  
-내용내용
-내용내용


**3) 인터셉터(Interceptor)**  
-내용내용
-내용내용

**4) 레플리케이션(Replication)**  
-내용내용
-내용내용










✨**일반 기능**  


✨**사용자 페이지**  
<img width="187" alt="ufav" src="https://user-images.githubusercontent.com/111713782/207254283-b01c1f9c-d3ac-4953-acb9-c0c8ffc0ef82.PNG">

**1) 메인페이지**  
- 내용내용
- 내용내용



**2) 로그인/회원가입**  
- ㅇㅇㅇ
- 


**3)  마이페이지**  
-ㅇㅇㅇㅇ


**4)  상품리스트**  
- 필터 / 정렬 중복 구현  
- 정가와 할인가가 다른 경우, 할인율 및 가격 표시  
- 페이지네이션 및 검색 기능 구현  
![1](https://user-images.githubusercontent.com/114971312/218421360-91e3f108-a655-4d64-97cd-488d36df6b75.JPG)
![2](https://user-images.githubusercontent.com/114971312/218421397-feb5f483-1866-41ea-8c4b-1c01dd2d4dfc.JPG)



**5) 장바구니**  
- ㅇㅇㅇ
- 

**6) 공지/이벤트/회사소개**  
- ㅇㅇ






✨**관리자 페이지**  


**1) 상품 관리**  
- ㅇㅇㅇ


**2) 회원 관리**  
- 차단된 회원 / 생년월일 순 정렬 기능  
- 이메일 / 이름 / 전화번호 검색 기능
- 차단 / 탈퇴 여부와 차단 설정 
![회원관리-min](https://user-images.githubusercontent.com/114971312/218416472-07d821de-5bb6-467d-b2e7-2129f09fb9c2.gif)




**3) 이벤트/공지사항 관리**  
**4) 후기/문의 관리**  
**5) 주문 관리**  

## 5. Troubleshooting

|&nbsp;&nbsp;Name&nbsp;&nbsp;|Issues|Problem solving|
|:--:|--|--|
|김기태|⦁ 문제점1<br>⦁ 문제점2|⦁ 솔루션1.<br>⦁솔루션2. | 
|연우진|⦁ 문제점1<br>⦁ 문제점2|⦁ 솔루션1.<br>⦁솔루션2. | 
|이상아|⦁ 문제점1<br>⦁ 문제점2|⦁ 솔루션1.<br>⦁솔루션2. | 
|한승우|⦁ 문제점1<br>⦁ 문제점2|⦁ 솔루션1.<br>⦁솔루션2. | 
