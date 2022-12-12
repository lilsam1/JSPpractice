<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 선언문 태그를 이용하여 실행 결과 확인
		Hello, Java Server Pages
	1) 선언문 태그에 문자형 전역변수를 선언하여 'Hello, Java Server Pages'를 저장
	2) 문자형 변수 값을 반환하는 전역 메서드 getString()를 작성
	3) getString() 메서드를 호출하여 문자형 변수 값을 출력 --%>
	
	<%! String data = "Hello, Java Server Pages";
		public String getString() {
			return data;
	}
	%>
	<%= getString() %>
</body>
</html>