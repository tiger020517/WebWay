<h1>WebService개발 HW1</h1>
22200182 / 김준형
<br>
<h2>프로젝트 개요</h2>
<br>
기본적인 JAVA CRUD를 만드는 것이다.
<br>
교수님이 주신 자료대로 List, ListLevel, Search, Create, Update, Delete, Savedata, Exit 기능들을 구현해야 한다.
<br>
<img src="https://github.com/csee-ps/project1-1-tiger020517/blob/main/assets/1.png">
프로그램 실행 시 File이 Load되는 모습
<br>
<img src="https://github.com/csee-ps/project1-1-tiger020517/blob/main/assets/2.png">
1번 메뉴 선택 시 현재 단어장 목록과 몇개의 단어가 추가되었는지 보여준다
<br>
<img src="https://github.com/csee-ps/project1-1-tiger020517/blob/main/assets/3.png">
4번 메뉴 선택시 새로운 단어를 추가 할 수 있다.
<br>
<img src="https://github.com/csee-ps/project1-1-tiger020517/blob/main/assets/4.png">
3번 메뉴 선택시 단어 검색이 가능하다. 특정 단어를 입력하면 해당 단어를 포함한 단어들을 찾는다
<br>
<img src="https://github.com/csee-ps/project1-1-tiger020517/blob/main/assets/5.png">
5번메뉴 선택시 던어 수정이 가능하고, 여기서 또 2번 메뉴 선택시 특정한 레벨들만 모아놓은 리스트를 볼 수 있다.
<br>
<img src="https://github.com/csee-ps/project1-1-tiger020517/blob/main/assets/6.png">
6번 메뉴 선택시 단어가 삭제 가능하고, 존재하지 않는 단어는 삭제되지 않는다.
<br>
<img src="https://github.com/csee-ps/project1-1-tiger020517/blob/main/assets/7.png">
7번 메뉴 선택시 test.txt 파일에 단어가 저장되게 되며, 0번 선택시 프로그램이 종료된다
<br>
<img src="https://github.com/csee-ps/project1-1-tiger020517/blob/main/assets/8.png">
test.txt에 저장된 내용들, Dictionary.txt는 github에 업로드되었으므로 따로 올리지 않는다.
<br><br>
<h2>클래스 설명</h2>
Word는 id, word, meaning, level로 이루어져있다.
<br>
wordCRUD는 정말 CRUD가 들어있으며, Read 부분은 우리가 만든 메뉴에 따라 전체, 레벨 별, 포함하는 단어별로 read 할 수 있다.
<br>
EnglishWordManager class는 Main java에서 실행하기 좋게 WordCRUD를 관리하며 프로그램을 시작시켜주는 역할을 한다.

<h2>향후 개선 아이디어</h2>
크게 3가지 아이디어 있었을 것 이라고 생각하였는데
<ul>
	<li>ID값을 활용한 기능</li>
	<li>비슷한 단어끼리 엮는 카테고리 기능</li>
	<li>유사어나 반의어 또는 예문을 추가하는 기능</li>
</ul>
어떤 아이디어든 추가되면 좋을 것 같다.