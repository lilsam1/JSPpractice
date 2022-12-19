<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	taglib 디렉티브 태그를 이용하여 조건에 맞게 애플리케이션을 만들고 실행 결과를 확인
	1)taglib 디렉티브 태그에 JSTL Core 태그를 설정하여 0부터 10까지의 짝수를 출력
	 --%>
	<c:forEach var="k" begin="0" end="10" step="2">
	 	<c:out value="${k}" />
	</c:forEach>
</body>
</html>