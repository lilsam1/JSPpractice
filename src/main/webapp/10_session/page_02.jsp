<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	String user_id = (String) session.getAttribute("userID");
	
	if (user_id == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<h2>회원 전용 페이지 입니다</h2>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>