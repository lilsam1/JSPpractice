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
		boolean isLogin = false;
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("userID") && cookies[i].getValue() != null ) {
				isLogin = true;
			}
		}
		//out.print(isLogin);
		if(isLogin) {
			out.print("admin님 반갑습니다<br>");
		}
		else {
			out.print("로그인 상태가 아닙니다");
		}
		
	%>
	<a href="cookie_out.jsp"> 로그아웃 </a>
</body>
</html>