<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	2.form 태그를 이용하여 다음 조건에 맞게 JSP 애플리케이션을 만들고 실행 결과를 확인
	1) form04.jsp 파일을 생성
	*input 태그 내에 text 유형을 이용하여 이름, 주소, 이메일 항목을 작성
	*form 태그의 action 속성 값은 form04_process.jsp로 작성
	
	2) form04_process.jsp 파일을 생성
	*Enumeration 클래스를 이용하여 전송된 모든 요청 파라미터 값을 받습니다
	*String을 이용하여 전송된 요청 파라미터 이름과 값을 저장하여 출력
	
	 --%>
	 
	<form action="form04_process.jsp">
		<p> 이름 <input type="text" name="name">
		<p> 주소 <input type="text" name="address">
		<p> 이메일 <input type="text" name="email">
		<p> <input type="submit" value="전송">
	</form>

</body>
</html>