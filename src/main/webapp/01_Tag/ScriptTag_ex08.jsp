<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 표현문 태그로 현재 날짜 출력 --%>
	<p> Today's date: <%=new java.util.Date()%></p>
	
	<%-- 스크립틀릿 태그를 이용하여 현재 날자 출력 --%>
	<% java.util.Date date = new java.util.Date(); 
	out.println(date);%>

</body>
</html>