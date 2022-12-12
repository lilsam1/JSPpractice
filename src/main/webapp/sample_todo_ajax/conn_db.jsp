<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	Connection conn = null;

	try {
		String url = "jdbc:mariadb://localhost:3308/sample_jsp_todo_ajax";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		conn = DriverManager.getConnection(url, user, password);
	} catch (SQLException ex){
		out.println("데이터베이스 연결이 실패되었습니다<br>");
		out.println("SQLException: " + ex.getMessage());
	}
%>    