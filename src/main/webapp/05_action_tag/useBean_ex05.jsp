<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>구구단 출력하기</h4>
	<jsp:useBean id="gugudan" class="user.GuGuDan" />
		<%	
		int num = 5;
		
		for (int i=1; i<10; i++) {
			out.print(num + " * " + i + " = " + gugudan.process(num, i) +"<br>");
		}
		%>
</body>
</html>