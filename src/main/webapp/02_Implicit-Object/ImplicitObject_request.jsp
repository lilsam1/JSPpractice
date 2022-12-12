<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 내장 객체
	request : 웹브라우저의 http 요청 정보 저장
	- <name = value> 형식으로 웹브라우저에서 서버의 JSP 페이지로 전달하는 정보를 저장
	- 클라이언트가 서버에 동작을 요구하는 것
	- JSP 페이지에서 가장 많이 사용되는 기본 내장 객체

	*요청 파라미터 관련 메서드
	getParameter(String name) - 요청 파라미터 이름이 name인 값을 전달. 파라미터 값이 없으면 NULL을 반환
	getParameterValues(String name) - 모든 요청 파라미터 이름이 name인 값을 배열 형태로 전달. 파라미터 값이 없으면 NULL을 반환
	getParameterNames() - 모든 요청 파라미터의 이름과 값을 Enumeration 객체 타입으로 전달
	
	*요청 HTTP 헤더 관련 메서드 - 부가적인 헤더 정보나 쿠키 관련 정보를 얻을 수 있는 메서드 제공
	
	*웹브라우저 서버 관련 메서드
	 --%>

</body>
</html>