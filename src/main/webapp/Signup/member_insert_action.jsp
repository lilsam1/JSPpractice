<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr>
		<th>name</th>
		<th>value</th>
	</tr>
	
	<%
		request.setCharacterEncoding("UTF-8");
	
		
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String name = (String) paramNames.nextElement();
			out.print("<tr><td>" + name + " </td>\n");
			String[] paramValue = request.getParameterValues(name);
 			out.println("<td> ");
 			if (paramValue != null) {
 				for (int i = 0; i < paramValue.length; i++) {
					out.println(" " + paramValue[i]);
				}
 			}
 			out.println("</td></tr>\n");
		}
	%>
		<td>IP</td> <td><%=request.getRemoteAddr() %></td>
	</table>
	
	<%--
	
	INSERT INTO member VALUES('a123', '321a', '김정기', 'a123@naver.com', '수영 등산', '05831', '서울 송파구 동남로 99 (가락동, 용현빌딩)', '502호', 1999, 11, 31, 'yes' , 'no', '0:0:0:0:0:0:0:1' );
	
	--%>
</body>
</html>