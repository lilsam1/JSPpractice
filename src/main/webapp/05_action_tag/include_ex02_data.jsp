<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String strNum = request.getParameter("num");
	int intNum = Integer.parseInt(strNum);
%>

<%
	for (int i = 1; i<10; i++) {
		out.print(intNum + " * " + i + " = " + (intNum*i) +"<br>");
	}
%>