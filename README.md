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
![밀키트 쇼핑몰](https://user-images.githubusercontent.com/117332944/218619937-f4350539-3c01-48bc-966e-7930759e1389.png)

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
|연우진|NCP에 서비스 전개 및 배포.<br>NCP에 MySQL Replication (Replica, Master) 진행<br><AI ChatBot(CLOVA), WebSocket을 활용한 사용자 문의처리 및 간편이용 시스템 개발.<br>관리자 페이지에서의 실시간 차트 및 통계 차트 관련 기능 개발(상단 데쉬보드 통계표).<br>사용자의 주문내역 관리 시스템 개발<br>사용자 페이지에서의 장바구니 기능 및 배송API(스마트 택배)를 활용한 배송조회 및 환불처리 기능 구현.<br>관리자, 사용자 메인화면(View) 설계.<br>사용자측 공지사항/이벤트/회사소개 페이지, 기능 구현.<br> 	|
|이상아|회원가입 및 로그인 관련 기능 구현<br>카카오 API를 이용한 소셜로그인 구현<br>인터셉터(Interceptor) 구현<br>마이페이지 구현<br>Spring Security를 이용한 Bcrypt 암호화 작업<br>관리자 페이지 문의/후기/답변 관리 구현<br>관리자 페이지 통계 기능 구현<br>(년도/월/일별 통계-화면 구성, 상세검색-배송량, 판매액, 판매된 제품 수, 구매확정)|
|한승우|아임포트(I'mport)을 활용한 결제 기능 구현<br>주문 관련 기능 구현<br>카카오 우편번호 API를 이용한 검색 기능 구현<br>사용자 배송지 선택,생성,삭제 및 기본배송지 설정 구현<br>장바구니, 배송지와 주문 연동 구현<br>Spring Security를 이용한 Bcrypt 암호화 작업<br>나의 주문리스트 페이지 구현<br>주문 상세 페이지 구현<br>관리자 페이지 상품,공지/이벤트 관리(CRUD) 및 이미지 파일 관련 기능 구현<br>관리자 페이지 실시간 통계 기능 구현<br>(매출차트,내아디별/성별 판매비율, 카테고리별 판매비율,주문당 평균)|
  

## 4. 프로젝트 구현 기능

✨**핵심 기능**  

<img width="187" alt="ufav" src="https://user-images.githubusercontent.com/111713782/207254283-b01c1f9c-d3ac-4953-acb9-c0c8ffc0ef82.PNG">



✨**사용자 페이지**  
**1) 챗봇(Chatbot)**  
- NAVER CLOVA Chatbot API를 활용하여 1:1 문의 등을 처리  
- 딥러닝 학습을 하여 가르치지 않은 대화도 가능
- 링크 답변을 통해 고객에게 직관적인 사이트 이용 경험을 전달  
![1](https://user-images.githubusercontent.com/114971312/218621174-7ab664ac-6421-43d7-9c13-7f9c179c97ad.JPG) 
  
![FINAL 시연 영상 - 4K mov_000279333-min](https://user-images.githubusercontent.com/114971312/218620626-d9855862-8de3-4535-af29-3ccf397d5224.gif)
![FINAL 시연 영상 - 4K mov_000294966](https://user-images.githubusercontent.com/114971312/218620635-8f4133c4-4c6f-4282-8c4b-0545f7a138ff.gif)


**2) 주문/결제(I'm port)**  
- 기본배송지가 있을 시 해당 배송지 정보를 바로 사용할 수 있게 표시
- 장바구니의 데이터를 가져와서 주문할 정보 생성
- I'mport(아임포트) API를 이용하여 카드결제, 카카오결제 등 실제 결제 가능   
![import_api-min](https://user-images.githubusercontent.com/117332944/218477489-658a1227-6b80-4580-8e55-d6dba3911172.gif)

**3) sns로그인(kakao)** 
- 카카오 로그인 API를 이용하여 소셜 로그인 구현
  →  SNS계정으로 처음 로그인을 하는 경우, 카카오 서버는 redirect url로 인증코드를 전달   
  → 클라이언트(Web)쪽에서 인증코드를 이용하여  access_token발급받은 후 서버로 전송   
  → 서버에서는 access_token을 이용하여 카카오 서버로부터 사용자 정보(이름, 이메일)를 받음   
  → 사용자정보를 db에 저장하며 로그인   
  <br>  
  ![카카오](https://user-images.githubusercontent.com/110235270/218476026-ffb0e851-fa6d-467e-98b3-cb0d7eab194b.gif)

  

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

![FINAL 시연 영상 - 4K mov_000269666](https://user-images.githubusercontent.com/114971312/218614121-be281a12-920e-4300-a1c0-787884ab4116.gif)



**6) 우편번호 검색 (다음 주소 API)**  
- 다음 주소 API를 이용하여 실제 주소를 사용할 수 있도록 구현  
  → API에서 가져온 결과를 필요한 양식으로 form 안에 들어가게 하여 DB에 저장
![daum_zipcode_api](https://user-images.githubusercontent.com/117332944/218469125-531cbb81-c9dc-40c2-b6b0-2de81232866a.gif)

✨**관리자 페이지**  
**1) 실시간 통계**  
- 실시간 데이터와 누적 데이터 표시
- Jquery, AJAX, JS의 SET INTERVAL 함수를 활용하여 실시간 통계 구현
- JAVA의 Date로 현재 기준 시간 설정, 데이터는 컨트롤러와 JSON형태로 전달
- 실시간 배송량, 판매량, 판매액, 구매확정률, 평균 판매 개수, 평균 판매 금액 데이터 표시
- 실시간 시간별 매출 차트, 전일 대비 매출차트, 인기 상품 TOP 10, 나이대 별 - 남녀 성별 판매 비율 데이터 표시

![FINAL 시연 영상 - 4K mov_000422100](https://user-images.githubusercontent.com/114971312/218614171-e06267c3-d579-4c7c-a4ba-3aab5a6bce21.gif)
![FINAL 시연 영상 - 4K mov_000541233](https://user-images.githubusercontent.com/114971312/218614241-9ca92892-de03-4421-b1c6-e3f89b65f000.gif)
  
![FINAL 시연 영상 - 4K mov_000483466](https://user-images.githubusercontent.com/114971312/218614207-61b9949d-1d25-4a4d-9faf-4affef00f508.gif)
![FINAL 시연 영상 - 4K mov_000500633](https://user-images.githubusercontent.com/114971312/218614211-80f8002d-b070-4445-9f45-7d10cb748b14.gif)
  
![FINAL 시연 영상 - 4K mov_000516266](https://user-images.githubusercontent.com/114971312/218614364-9a7946b1-1fb3-4b19-a05d-41758728c578.gif)
![FINAL 시연 영상 - 4K mov_000525566](https://user-images.githubusercontent.com/114971312/218614386-5025d45c-2e61-4ab3-b125-4c9647923c8f.gif)


**2) 년도/월/일별 통계**  
- 시간별 배송량, 판매액, 판매수, 구매확정률, 인기 상품, 매출 차트 등 정보 확인 가능
- 정규식을 이용하여 3자리 마다 컴마(,)를 통해 관리자가 쉽게 파악
- 날짜 tag 에 ‘selected’ class가 추가된 tag를 확인해 선택한 날짜를 전달
- 1일, 31일/1월, 12월 등 월 또는 년도가 바뀌는 시기에는 그에 맞춰 날짜가 변경되게 구현



**3) 통계 상세 검색**  
- 음식카테고리별/나이대별/성별/날짜등의 조건을 중복으로 선택하여 데이터 상세 검색 가능
- 선택한 조건에 CSS 가 추가되게 하여 관리자가 쉽게 파악할 수 있도록 구현  



✨**기타**  

**1) 로드밸런서**  
-내용내용
-내용내용


**2) 암호화(Bcrypt)**  
- Bcrypt 암호화를 통해 사용자의 비밀번호를 암호화하여 DB에 저장 
![Bcrypt](https://user-images.githubusercontent.com/117332944/218469822-ab092b85-7b05-46d5-8e48-383963fbd8f3.png)  
![bcrypt_db_sql](https://user-images.githubusercontent.com/117332944/218470004-facf7933-fb91-47bd-b6ef-8849f71656c0.png)  
- 사용자가 입력한 비밀번호를 Bcrypt hash algorithm 적용 후 DB에 저장된 암호와 match하여 확인  
- Bcrypt hash algorithm 적용 시 임의의 salt를 생성하기 때문에 같은 입력값에 대해서 매번 다른 결과를 반환하여 강력한 보안 가능  


**3) 인터셉터(Interceptor)**  
- 로그인한 사용자만 볼 수 있도록 일부 페이지들에 대한 접근을 막음   
- 세션을 통해 로그인 여부를 체크해서 로그인하지 않은 회원은 로그인 폼으로 보냄 

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
- 회원 가입 시 jQuery를 활용해 ID 중복 여부 체크 
- 회원 가입 form의 모든 항목에 대해 유효성 검사 실시
- 비밀번호 찾기 & 아이디 찾기 구현
 → 아이디 찾기 시 아이디(email)의 일부만 보여주도록 함   

![중복체크](https://user-images.githubusercontent.com/110235270/218476271-c228cde0-0fcd-4256-908b-41b731c498e1.gif)
 


**3)  마이페이지**  
- 비밀번호 변경, 찜 내역, 나의 주문/후기/문의 내역, 회원 탈퇴 기능
- 후기 및 문의 조회/수정/삭제 가능 
- 회원 탈퇴 시 회원 테이블의 signout 컬럼을 'N' -> ' Y'로 변경
 → 해당 아이디로 로그인 및 가입 불가


**4)  상품리스트**  
- 필터 / 정렬 중복 구현  
- 정가와 할인가가 다른 경우, 할인율 및 가격 표시  
- 페이지네이션 및 검색 기능 구현  
![1](https://user-images.githubusercontent.com/114971312/218422029-547948fc-be82-43bc-8dbd-6faf8aacc77b.JPG)
![2](https://user-images.githubusercontent.com/114971312/218421397-feb5f483-1866-41ea-8c4b-1c01dd2d4dfc.JPG)



**5) 장바구니**  
- ㅇㅇㅇ
- 

**6) 배송지 관리**  
- 팝업창을 띄워 배송지를 관리할 수 있게 구현 (배송지 선택, 기본 배송지 설정, 생성, 삭제)  
- 배송지 선택 클릭 시 부모창으로 배송지 주소를 submit하고 자식창은 닫히게 구현  
- controller에서 전달받은 배송지 리스트를 이용해 해당 사용자가 등록한 배송지가 3개 이상일 시 배송지 추가 불가능  
![addresspop](https://user-images.githubusercontent.com/117332944/218482602-13dddfe2-57f9-4f64-a630-e19ed021647c.png)  


**7) 공지/이벤트/회사소개**  
- 기
- 배





✨**관리자 페이지**  


**1) 상품 관리**  
- 필터와 정렬을 중복으로 적용하여 상품 조회 가능
- 상품의 이미지 파일을 포함한 모든 요소를 등록/수정이 가능
- 중복된 파일명이 있을 경우 뒤에 숫자를 계속하여 추가하는 식으로 재귀함수로 구현 (ex: (1), (2), (3))
<img width="100%" alt="itemmanage" src="https://user-images.githubusercontent.com/117332944/218488653-8f012552-f61e-4231-b46a-d446ad49923b.gif"> 

![image](https://user-images.githubusercontent.com/117332944/218489047-f4afb805-8e16-4e31-9519-94ff35b0d414.png)

- 상품 삭제 시 실제로 데이터를 삭제하면 여러 문제가 발생할 수 있기 때문에 테이블의 'deleted' 필드를 'Y'으로 변경하게 구현

**2) 회원 관리**  
- 차단된 회원 / 생년월일 순 정렬 기능  
- 이메일 / 이름 / 전화번호 검색 기능
- 차단 / 탈퇴 여부와 차단 설정  
![회원관리-min](https://user-images.githubusercontent.com/114971312/218416472-07d821de-5bb6-467d-b2e7-2129f09fb9c2.gif)


**3) 공지/이벤트 관리** 
- 필터와 정렬을 중복으로 적용하여 공지/이벤트 조회 가능
- 작성자는 session에서 로그인 정보를 불러와 고정
- 중복된 파일명이 있을 경우 뒤에 숫자를 계속하여 추가하는 식으로 재귀함수로 구현 (ex: (1), (2), (3))
<img width="100%" alt="boardmanage" src="https://user-images.githubusercontent.com/117332944/218490427-2e2e4f9a-0800-4c98-942f-335ac4cdaf40.gif"> 

**4) 후기/문의 관리** 
- 검색 기능을 통해 해당 키워드에 맞는 글을 가져오도록 구현 
- 일부 선택 or 전체 선택하여 삭제 
- 문의글의 경우, 관리자가 답변을 쓸 수 있도록 댓글 입력/수정/삭제 기능 구현

**5) 주문 관리**  

## 5. Troubleshooting

|&nbsp;&nbsp;Name&nbsp;&nbsp;|Issues|Problem solving|
|:--:|--|--|
|김기태|⦁ 문제점1<br>⦁ 문제점2|⦁ 솔루션1.<br>⦁솔루션2. | 
|연우진|⦁ 문제점1<br>⦁ 문제점2|⦁ 솔루션1.<br>⦁솔루션2. | 
|이상아|⦁ 문제점1<br>⦁ 문제점2|⦁ 솔루션1.<br>⦁솔루션2. | 
|한승우|⦁ 문제점1<br>⦁ 문제점2|⦁ 솔루션1.<br>⦁솔루션2. | 
