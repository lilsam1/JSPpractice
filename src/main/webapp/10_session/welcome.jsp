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
	%>
	<h3><%=user_id%>님 환영합니다</h3>
	<a href="session_out.jsp"> 로그아웃 </a>

</body>
</html>