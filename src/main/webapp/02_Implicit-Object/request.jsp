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
	request 내장 객체를 이용하여 JSP 애플리케이션을 만들고 실행 결과를 확인
	1)request.jps 파일을 생성
	*input tag의 text 유형을 이용하여 아이디, 비밀번호 항목을 작성
	*form 태그의 action 속성 값은 request_process.jsp로 method 속성 값은 get으로 작성
	
	2)request_process.jsp 파일을 생성
	*request 내장 객체의 getQueryString()메서드를 이용하여 전송된 요청 파라미터와 값을 출력 --%>
	
	<form action="request_process.jsp" method="get">
		<p>아이디 <input type="text" name="id">
		<p>비밀번호 <input type="text" name="passwd">
		<p> <input type="submit" value="전송" />
	</form>

</body>
</html>