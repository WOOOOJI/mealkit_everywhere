# Mealkit-Everywhere -  🍲
팀장: 김기태  팀원: 연우진, 이상아, 한승우  
기간: 2023.01.06~2023.02.17  
🔗[소비자 웹 페이지 시연영상](https://youtu.be/zLp9kFtKYJY)  
🔗[관리자 웹 페이지 시연영상](https://youtu.be/40AijHLPro4)

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
✨**시스템 구성도** 

<img width="736" alt="전체시스템구성도" src="https://user-images.githubusercontent.com/111727476/207280298-e7932e7a-52ad-453e-93c5-ca2773c1f25f.png">

<br>

✨**NCP시스템 구성도**

<img width="736" alt="ncp구성도" src="https://user-images.githubusercontent.com/111727476/207198802-2daf6818-de21-4043-81ac-464e5cbdc7b4.png">

✨**개발 환경 및 수행 도구**

|개발도구|협업도구|언어|DB|프레임워크|API|SERVER|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|Eclipse 2020-12|Github<br>Zoom<br>ERD Cloud<br>Google Docs|Java<br>JavaScript<br>HTML5<br>CSS3<br>SQL<br>AJAX|MySQL 8.0|Spring Boot 2.77<br>MyBatis<br>Thymeleaf|카카오 로그인<br>스마트 택배<br>아임포트(I'mport)<br>카카오 우편번호<br>Naver Chatbot|Tomcat 9.0<br>NCP(Naver Cloud Platform)|

✨**DB 설계**

<img width="985" alt="FINAL_FINAL_UART_ERD - 복사본" src="https://user-images.githubusercontent.com/110188342/207698454-6077d4c4-fdf9-459e-b7a2-cfcd5938bc1d.png">

✨**UI 설계**

<img width="933" alt="통합UI" src="https://user-images.githubusercontent.com/111713782/206375750-e2ce8aac-66f5-427b-97c1-596ae4f5ae28.PNG">

## 3. 프로젝트 역할분담

|이름|역할|
|--|--| 
|김기태|상품 리스트 페이지 구현<br>게시판 페이지네이션 구현<br>상품 상세 페이지 구현<br>문의 - 후기 게시판(CRUD) 구현<br>챗봇 API 및 WebSocket을 이용한 문의 처리 구현<br>관리자 회원관리 게시판(조회, 차단 설정) 구현<br>관리자 통계 기능 구현(전일 대비 판매 차트 구현, TOP-WORST10 상품리스트 구현)|  
|연우진|NCP에 서버 전개 및 DB(Replication) 설치<br>AI ChatBot, WebSocket을 활용한 사용자 문의처리 및 간편이용 시스템 개발.<br>관리자 페이지에서의 실시간 차트 및 통계 차트 관련 기능/주문 관리기능 개발.<br>사용자 페이지에서의 장바구니 기능 및 배송API를 활용한 배송조회 기능 개발.<br>관리자, 사용자 메인화면(View) 설계.|
|이상아|회원가입 및 로그인 관련 기능 구현<br>카카오 API를 이용한 소셜로그인 구현<br>인터셉터(Interceptor) 구현<br>마이페이지 구현<br>Spring Security를 이용한 Bcrypt 암호화 작업<br>관리자 페이지 문의/후기/답변 관리 구현<br>관리자 페이지 통계 기능 구현<br>(년도/월/일별 통계-화면 구성, 상세검색-배송량, 판매액, 판매된 제품 수, 구매확정)|
|한승우|아임포트(I'mport)을 활용한 결제 기능 구현<br>주문 관련 기능 구현<br>카카오 우편번호 API를 이용한 검색 기능 구현<br>사용자 배송지 선택,생성,삭제 및 기본배송지 설정 구현<br>장바구니, 배송지와 주문 연동 구현<br>Spring Security를 이용한 Bcrypt 암호화 작업<br>나의 주문리스트 페이지 구현<br>주문 상세 페이지 구현<br>관리자 페이지 상품,공지/이벤트 관리(CRUD) 및 이미지 파일 관련 기능 구현<br>관리자 페이지 실시간 통계 기능 구현<br>(매출차트,내아디별/성별 판매비율, 카테고리별 판매비율,주문당 평균)|
  

## 4. 프로젝트 구현 기능

✨**주요 기능**

<img width="187" alt="ufav" src="https://user-images.githubusercontent.com/111713782/207254283-b01c1f9c-d3ac-4953-acb9-c0c8ffc0ef82.PNG">

**1) sns로그인(+kakao/naver)&로그아웃**
- SNS계정으로 처음 로그인을 하는 경우, 카카오/네이버 서버는 redirect url로 인증코드를 전달   
  → 클라이언트(Web)쪽에서 인증코드를 이용하여  access_token발급받은 후 서버로 전송   
  → 서버에서는 access_token을 이용하여 카카오/네이버 서버로부터 사용자 정보(이름, 이메일, 성별)를 받음   
  → 사용자정보를 db에 저장함으로서 회원가입 진행한 후 로그인되도록 구현
  
  ![sns계정 로그인 처음하는 경우](https://user-images.githubusercontent.com/111714371/207106848-62fa52a0-f633-417b-8666-e414a160ec09.gif)

- SNS계정이 이미 있는 경우, 해당 계정으로 로그인 되도록 구현

![sns계정 이미 있는 경우](https://user-images.githubusercontent.com/111714371/207106968-0635e8aa-d32e-4b2f-890e-3927ae31c855.gif)

<br>

**2-1) 공연•전시 상세페이지(상세정보, 예매/취소 안내)**  
- Bootstrap tab을 사용하여 한 페이지에서 다양한 정보 탐색 가능
- 카카오 API 사용하여 지도정보 전송 => db에 있는 전시장소별 위도 & 경도 데이터를 가져와서 해당 위치의 지도정보 화면에 보여줌 

![전시 상세페이지 탭 정보](https://user-images.githubusercontent.com/111714371/207085031-e3e6a633-7ac2-4df7-b13d-6ac8fe1fcf74.gif)

**2-2) 공연•전시 상세페이지(한줄평)**  
- 해당 전시 예매내역이 있는지 여부 확인 & 예매내역이 있는 경우, 리뷰 작성을 한적이 있는지 여부 확인
- 해당 전시 예매자만 리뷰 작성이 가능하되 리뷰 중복 작성 방지되도록 기능 구현  

![한줄평 기능상세](https://user-images.githubusercontent.com/111714371/207085188-7c312b56-8ff2-4a8d-b8b8-8425dd05b941.gif)

**2-3) 공연•전시 상세페이지(sns공유하기)**  
- URL을 전달하여 SNS 공유하기 기능 구현 카카오 API를 활용하여 제작한 카카오 메시지 템플릿 전송  

![상품 카톡 공유](https://user-images.githubusercontent.com/111714371/207085438-de7a03d6-b779-4ea0-a4f4-fbb6d8aa15ac.gif)

<br>

**3) 검색 및 검색어 자동완성기능**
- ajax 이용하여 form 전송
- jQuery 라이브러리를 사용 => JSON Array를 사용하여 배열을 만들고 ajax 이용하여 전송

![검색기능 자동완성 포함](https://user-images.githubusercontent.com/111714371/207086199-3c657ea0-c196-4a1e-9f0e-336126206161.gif)

<br>

**4) OCR 수험생 인증 이벤트**

<img width="889" alt="OCR수험생 이벤트" src="https://user-images.githubusercontent.com/111713782/206957643-49aa0308-ce02-4ebf-b2bc-88e947a23999.PNG">

- Naver Cloud Platform의 CLOVA OCR에 수험표 검증에 필요한 영역들(수험년도, 이름, 주민등록번호 앞자리, 수험번호)을 설정함.
- 사용자가 U-ART 에서 수험표 이벤트 참여를 위해 사진을 업로드하면 OCR을 통해 JSON형태의 응답을 받음
- 수험표 사진인지 여부를 판별  
수험표 사진일 경우, 이번년도 수험표인지 여부와 db에 있는 사용자 정보와 일치하는지 여부 판별,  
모든 조건에 일치하는 경우에만 전시예매 50% 할인 쿠폰 지급, 해당 이벤트의 중복 참여를 방지하기 위해 이벤트 참여 회원의 수험번호를 db에 저장

![수험생이벤트OCR](https://user-images.githubusercontent.com/111714371/207086352-1f24057a-c427-4752-a83e-5dd36bc2f9d0.gif)

- 모바일 환경에서는 사진 촬영 후 업로드하는 방식으로 OCR 수험생 인증 이벤트 참여 가능

![모바일 ocr 이벤트 참여](https://user-images.githubusercontent.com/111714371/207296421-c3f9498f-1e40-46a0-9afd-35ba31e9f0f3.gif)

<br>

**5) 챗봇**

<img width="907" alt="챗봇" src="https://user-images.githubusercontent.com/111713782/206958397-61d94768-8d61-4d29-9878-2dd64f1ffc27.PNG">

- 웹소켓: 접속되어 있는 서버간 통신가능 =>접속되어 있는 모든 사용자 사용가능
- Naver Cloud Platform의 CLOVA Chatbot 빌더 실행=> 대화목록 생성
- Websocket을 사용하여 관리자페이지에 서버 생성(관리자페이지의 서버에 소비자페이지를 접속시켜 기능 구현)  
- 등록된 질문 입력시 그에 해당되는 답변 전송(로그인 후 사용가능한 기능으로 구현하여 사용자의 이름을 상단과 채팅창에 출력하여 실제 채팅하는 환경 조성, 
연결상태를 한 눈에 볼 수 있도록 시작/종료 상태 알림)

![챗봇](https://user-images.githubusercontent.com/111714371/207086989-31fd0cd6-5569-4e59-9709-7dd571e7f3ea.gif)

<br>

**6) 예매 및 결제**
- 대상에 따라 상이한 가격정보와 수량 데이터 가져오기
- 이벤트 테이블의 sort 필드 값  
1 : 이벤트 참여로 지급된 쿠폰   사용하지 않은 경우/ 0 : 이벤트 참여로 지급된 쿠폰 사용한 경우  
 => 결제시, 50%할인쿠폰 중복으로 적용되지 않도록 함  
 => 쿠폰적용 가능여부에 따른 버튼 활성화/비활성화
- I’mport(아임포트) API 사용하여 실제 가능한 결제기능 구현

![추천전시에서 결제완료페이지](https://user-images.githubusercontent.com/111714371/207085999-910c0c3b-21f6-4273-8222-bbc0ae0d39e7.gif)

<br>

**7) 예매 및 결제(모바일 환경)**
- I’mport(아임포트) API 사용하여 모바일 웹 환경에서도 결제 가능하도록 구현
- 모바일 웹 환경에서는 특정 PG사(ex.KG 이니시스..)의 웹사이트로 리디렉션되면 requestPay()함수에 지정한 callback 함수가 메모리에서 해제되기 때문에, pc 웹 환경에서와 달리 결제 프로세스 완료 후 callback 함수가 실행될 수 없음   
  => requestPay()함수에 결제 프로세스 완료 후 리디렉션 될 URL을 지정함   
  => redirect_url의 파라미터로 데이터를 서버로 넘겨서 db에 결제 데이터가 들어가도록 함  

![모바일결제](https://user-images.githubusercontent.com/111713782/206960430-fa4653da-e47f-437a-a3af-3777d121a09b.gif)

<br>
<br/>
<img width="175" alt="afav" src="https://user-images.githubusercontent.com/111713782/207254274-e7ee8174-4bcc-4c5d-be07-1ea92cafb7b5.PNG">
   
**1) 전시 일정 fullcalendar조회**  
- 라이브러리 사용
- 전시별로 색상을 다르게 적용하여 전시일정을 한눈에 알아보기 쉽게 구현  
  => 전시명 클릭시 전시조회 페이지로 이동하여 수정 및 삭제 가능하도록 함

![전시일정 스케줄](https://user-images.githubusercontent.com/111714371/207089868-5fdd0b93-f969-408d-95ae-4180a8192930.gif)

<br>

**2) 매출 차트**
- Highcharts를 이용함  
  - GROUPBY를 통해 전시 카테고리를 기준으로 월별 매출액 구현  
  - GROUPBY를 통해 성별을 기준으로 월별 매출액 구현    
  - AJAX를 통해 월별 기간을 잡고, GROUPBY를 통해 성별을 기준으로 기간별 매출액 비율을 구현
- 롤링배너를 통해서 ‘리뷰별점 추천전시 6’를 HTML로 화면에 나타냄

![매출차트 최신](https://user-images.githubusercontent.com/111714371/207097049-46195cea-ce7a-4625-a5c7-41bd73174bbd.gif)

<br>

**3) 페이징 처리 & 반응형 웹**  
- U-ART Admin_태블릿

![관리자 모바일](https://user-images.githubusercontent.com/111713782/206995790-53c04566-6b8d-4033-8493-4b648f5893ff.gif)  
</details>

❗소비자웹사이트에도 공통적으로 적용함.

<br><br>
✨**일반 기능**

<img width="187" alt="ufav" src="https://user-images.githubusercontent.com/111713782/207254283-b01c1f9c-d3ac-4953-acb9-c0c8ffc0ef82.PNG">

**1) 회원가입 및 로그인&로그아웃/회원정보 조회/수정/탈퇴**  
- jQuery를 활용해 post방식으로 form 전송  
- 회원탈퇴 시 ‘withdrawal’필드 값 ‘1 (회원)’→ ‘0 (탈퇴)’ 변경  
=> 중복아이디로 다시 가입 불가  
=> 해당 아이디로 로그인 불가  

![회원가입 로그인 회원정보수정 및 탈퇴](https://user-images.githubusercontent.com/111714371/207083678-09bf1b25-f6fd-44bd-b7bb-31b110612b08.gif)

<br>

**2) 카테고리별 정렬 및 추천작품(별점순)** 
- XML query문 사용하여 맵핑하여 Mapper 함수호출 
- 전시 카테고리 별 화면구현/ 전시 마감순/시작순 목록구현/ 리뷰 별점순 추천작품 목록 구현
- 공연예술 페이지 - 공공데이터 포털 API호출하여 가져온 데이터를 화면에 나타냄

![카테고리별 전시목록 필터링 기능](https://user-images.githubusercontent.com/111714371/207107219-f9d72dab-c0ba-4a19-95e2-f3d97a0a58e8.gif)

![추천전시 공연예술 ](https://user-images.githubusercontent.com/111714371/207107366-9c83ea1a-5a09-481e-b5fb-9f4cf7a820c5.gif)

<br>

**3) 위시리스트**
- Mapper 함수를 사용하여 위시리스트 중복확인 가능한 모달 구현
- 함수 onclick 기능 사용하여 위시리스트로 이동가능한 모달 구현

![위시리스트 중복방지 기능 포함](https://user-images.githubusercontent.com/111714371/207085681-96d11b03-6641-40de-86a9-bf45c435333d.gif)

<br>

**4) 예매내역**
- 취소가능일에만 예매취소가 가능하도록 기능 구현
- 예매취소버튼 클릭   
  => jQuery로 취소하려는 날짜와 취소가능일 비교하는 함수 호출   
  => 예매취소가 가능한 경우, ajax로 해당 데이터 전송 후 예매내역 삭제   
  => 모달창으로 알림  

![예매내역 취소가능일에만 삭제가능](https://user-images.githubusercontent.com/111714371/207085859-27b7a3ec-f945-411d-97e0-05a059b05437.gif)

<br>
<br/>

<img width="175" alt="afav" src="https://user-images.githubusercontent.com/111713782/207254274-e7ee8174-4bcc-4c5d-be07-1ea92cafb7b5.PNG">

**1)회원가입 및 로그인&로그아웃** 
- 관리자 레벨에 따라 권한 다르게 부여 => A레벨 관리자(admin01)만 A레벨 관리자(admin01)만 관리자정보 탭 조회 및 등록 가능

![관리자 회원가입 권한부여 로그인 앤 아웃](https://user-images.githubusercontent.com/111714371/207087132-514a2114-62d0-4efd-8fc4-a939f5cb88dd.gif)

<br>

**2) 고객정보, 예매내역 조회 및 검색**  
- 고객 정보와 예매 내역 정보 각 화면에 구현하기
  => 소비자 & 관리자 페이지간 연동 이뤄지도록 구현
- Thymeleaf를 사용하여 동적인 html 구현
- 예매날짜 빠른순/최신순 정렬 기능 구현
  =>검색 후 결과에 정렬기능 적용하기 위해 검색controller에 검색입력값 객체 생성.

![관리자 회원조회 예매내역 조회](https://user-images.githubusercontent.com/111714371/207088799-83f86663-2741-4466-9940-41c2b19a23dc.gif)

<br>

**3) 관리자 정보 조회(수정/삭제)&등록**
- 관리자 ID에 <a></a>를 적용하여 상세정보 조회로 이동 가능
- jQuery 사용하여 관리자정보 update/delete 기능 구현
- 기능적용의 확인을 위한 alert창 구현

![관리자정보 조회 수정 삭제](https://user-images.githubusercontent.com/111714371/207089319-e36def29-5e12-41ef-bc64-69839e05d2b0.gif)

<br>

**4) 전시 목록 조회(수정/삭제)&등록**
- Thymeleaf를 사용하여 동적인 html 구현
- form과 MultipartFile 기능 사용하여 파일도 등록가능하도록 구현
- 소비자 웹 사이트와 연동시켜 관리자 웹사이트에 등록시 소비자 웹 사이트에도 자동으로 등록되도록 구현
- 화면(String 자료형)과 서버(Date 자료형)에서 교환되는 날짜정보를 각 위치에 적합한 형식으로 변환하여 데이터값을 전송하여 기능구현  

![전시 수정 삭제](https://user-images.githubusercontent.com/111714371/207111211-b08a6f28-951c-4a00-b343-b8c451bbd5b0.gif)

![전시 등록](https://user-images.githubusercontent.com/111714371/207111322-163e5aba-d43a-4010-a486-3ec7062e5583.gif)



## 5. Troubleshooting

|&nbsp;&nbsp;Name&nbsp;&nbsp;|Issues|Problem solving|
|:--:|--|--|
|조재윤|⦁ 네이버 오픈 API를 활용하여 javascript로 네이버 로그인을 구현할 때 네이버 서버와는 연결이 되어 접근 토큰(access token) 값까지 받았는데 사용자 정보를 가져오지 못하는 문제가 생김.<br>⦁ 아임포트 결제 기능 구현할 때 pc 웹 환경에서와 달리 모바일 웹 환경에서 결제까지는 되는데 결제 데이터가 db에 반영되지 않는 문제가 생김.<br>⦁ 공공데이터 포털 API를 호출하여 이클립스 환경에서 JUnit Test로 데이터들이 잘 들어왔는지 확인할 때 여러 요청변수들을 어떤 형식으로 명시해줘야 하고 XML 형식의 데이터를 parsing할 때는 어떤 방식으로 해야하는지 어려움이 있었음.<br>⦁ 페이징 기능을 구현할 때 한 블럭에 해당하는 `startpage`와 `endpage`를 컨트롤러로부터 가져와서 화면에 어떤 식으로 page를 지정해주고 각각의 페이지에 나타내는 데이터 수를 어떻게 설정해줘야 하는지 어려움이 있었음.|⦁ callback하는 과정에서 접근 토큰 값으로 네이버 서버로부터 사용자 정보를 불러와서 `navercallback.html`로 화면에 해당 데이터가 잘 가져와졌는지 확인할 수 있도록 매핑 작업을 해줌.<br>⦁ 모바일 웹 환경에서 아임포트 결제 API를 연동할 때 특정 PG사의 경우 pc 웹 환경에서와 달리 결제 프로세스 완료 후 callback 함수가 호출되지 않는다는 점을 아임포트 개발문서에서 알게되었고, 해결을 위해 `requestPay()`함수에 결제 프로세스 완료 후 리디렉션 될 URL을 지정하였음. redirect_url의 파라미터로 데이터를 서버로 넘겨서 db에 결제 데이터가 들어가도록 함.<br>⦁ apiurl 뒤에 `+ "& "`를 통해 여러 개의 요청변수들을 명시할 수 있고 데이터를 가져오는 개수도 요청변수를 통해 설정할 수 있음을 알게 되었음. XML 형식의 데이터를 parsing할 때 `getTagValue`로 필요한 태그 정보들만 불러와 데이터를 활용할 수 있음을 알게 되었음.<br>⦁ mapper파일에 `LIMIT`(가져올 데이터의 양)과 `offset`(가져올 데이터의 초기 위치값) 으로 select 함수를 만들어서 한 페이지당 몇 개씩 데이터가 나오도록 설정해줌.<br>`th:each="page : ${#numbers.sequence(startpage,endpage)}"` 로 시작과 끝 구간에 해당하는 만큼 반복해서 page 값을 받아서 화면에 나타내도록 함. 
|김서윤|⦁ localhost에서 작동되는 group by가 포함된 쿼리가 NCP서버에서는 1055 에러로 작동되지 않아서 차트가 나오지 않음.<P></P> ⦁ 한 개의 전시 상품옵션에서 대상이 성인,청소년,어린이로 나누어지고 가격도 3개가 나와야 하는데 DB에 어떻게 나타내야 코딩하기 쉬울 지 모르겠음. |⦁ 방법1. group by 사용 시 select의 칼럼 중 집계함수에 쓰이는 칼럼을 제외한 모든 칼럼을 기입해야 함. <br> ⦁ 방법2. $ vi /etc/my.cnf 에서 sql_mode에서 ONLY_FULL_GROUP_BY 설정을 제거해야 함. <P></P><br> ⦁ 대상 칼럼도 3개, 가격 칼럼도 3개 만들면 됨.&nbsp; 그래서 insert 한번에 해당 전시의 대상 3개, 가격 3개가 다 들어가야함.&nbsp; 대상 칼럼 1개, 가격 칼럼 1개 만드는 경우 대상 3개, 가격 3개 넣으려면 insert 3번 해야함.&nbsp; 이러면 코딩 이용하기 어려움(가능은 함). |
|조재원|⦁ 반응형 웹 템플릿을 사용했음에도 모바일 버전에서 화면 깨짐 현상이 발생함.<br>⦁ 카카오톡 공유하기 버튼을 한번 이상 누를 때 `Kakao.init`오류 발생.|⦁ 템플릿의 고유한 틀을 벗어나서 외부에서 반응형 탭/캐러셀등을 삽입했을 때 이러한 현상이 발생할 수 있으므로 `@media`작업을 통해 해결해줘야 함.<br>⦁ initialize가 두번 호출 되는 경우 오류가 발생하므로 초기화 되었을 때에는 init을 호출하지 않고, 초기화 되지 않은 상황에서만 호출되도록 if문을 사용해줌.| 
|이현지|⦁ 화면과 서버의 간의 날짜데이터 전송이 원활하지 않아 DB에 정보가 저장되지 않음.<br>⦁ 템플릿과 구현기능의 충돌로 자동완성된 검색어 출력이 원활하지 않음.|⦁ 화면의 데이터를 전송하고 받을 수 있는 String형 변수를 DTO에 추가한 후 Controller에서 형변환을 통해 Date형식과 String형식을 양쪽에 적합하게 전송하여 해결.<br>⦁ z-index와 검색창 위치조절(CSS)로 해결. | 
|박재형|⦁ sql구문에 맞춰서 xml파일을 잘 맟추지 않아서 정보가 화면에 나오지 않았다.<br> ⦁ 지도 화면에 구현하는 과정에서 기존에 배웠던 대로만 하려고 해서 지도가 제대로 안 나오는 문제점이 있었음. | xml파일의 문법을 올바르게 고치니 제대로 된 정보가 나왔다. 앞으로 할때 항상 주의하자.<br> ⦁ 처한 상황에 맞게끔 코드를 수정하여 문제를 해결함. |
