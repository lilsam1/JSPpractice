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
	form 태그를 이용하여 조건에 맞게 JSP 애플리케이션을 만들고 실행결과를 확인
	1)form05.jsp 파일을 생성
	*input 태그 내에 check 유형을 이용하여 오렌지, 사과, 바나나 항목을 작성
	*form 태그의 action 속성 값은 form03_process.jsp로 작성
	
	2)form05_process.jsp 파일을 생성
	*request 내장 객체의 getParameterValues() 메서드를 이용하여 전송된 요청 파라미터 값을 전달받아 출력
	--%>
	
	<form action="form05_process.jsp">
		<p>오렌지<input type="checkbox" name=fruit value="orange">
		<p>사과<input type="checkbox" name=fruit value="apple">
		<p>바나나<input type="checkbox" name=fruit value="banana">
		<p><input type="submit" value="전송">
	</form>
</body>
</html>