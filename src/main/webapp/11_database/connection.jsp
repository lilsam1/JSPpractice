<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database SQL</title>
</head>
<body>
	<%--
	JDBC API로 데이터베이스 접속
	1) Connection 객체를 null로 초기화
	2) 데이터베이스와 연동하기 위해 JDBC를 로딩하도록 Class.forName() 메서드 작성
	3) DriverManager 객체로부터 Connection 객체를 얻어오도록 getConnection() 메서드 작성
	--%>
	<%
		Connection conn = null;
		try {
			String url = "jdbc:mariadb://localhost:3308/sample";
			String user = "root";
			String password = "1475";
					
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			out.println("데이터베이스 연결이 성공되었습니다");
		} catch (SQLException ex) {
			out.println("데이터베이스 연결이 실패되었습니다.<br>");
			out.println("SQLException: " + ex.getMessage());
		} finally {
			if (conn != null)
				conn.close();
		}
	%>

</body>
</html>