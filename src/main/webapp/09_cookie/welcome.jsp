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
		String userId = null;
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("userID") && cookies[i].getValue() != null ) {
				userId=cookies[i].getValue();
			}
		}
		//out.print(isLogin);
		if(userId == null) {
			response.sendRedirect("cookie.jsp");
		}
	%>
	<h3><%=userId%>님 환영합니다"</h3>
	<a href="cookie_out.jsp"> 로그아웃 </a>
</body>
</html>