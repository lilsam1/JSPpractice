<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database SQL</title>
</head>
<body>
	<%@ include file="dbconn.jsp" %>
	<%
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		// ResultSet, Statement 참조변수를 null로 초기화
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			// member 테이블의 폼 페이지에서 전송된 id와 일치하는 레코드를 찾아 id, passwd 필드 값을 가져오도록 SELECT 문 작성
			String sql = "select id, passwd from member where id = '" + id + "'";
			// Statement 객체를 생성하도록 createStatement() 메서드 작성
			stmt = conn.createStatement();
			// SELECT 문을 실행하도록 Statement 객체의 executeQuery() 메서드 작성
			rs = stmt.executeQuery(sql);
			
			// SELECT 문으로 가져온 레코드가 있으면 반복
			if (rs.next()) {
				String rId = rs.getString("id");
				String rPasswd = rs.getString("passwd");
				
				if (id.equals(rId) && passwd.equals(rPasswd)) {
					// member 테이블에서 폼 페이지로부터 전송된 id와 일치하는 레코드를 찾아
					// name 필드 값을 변경하도록 UPDATE문을 작성
					sql = "update member set name = '" + name + "' where id = '" + id + "'";
					// Statement 객체를 생성하도록 createStatement() 메서드 작성
					stmt = conn.createStatement();
					// UPDATE 문을 실행하도록 Statement 객체의 executeUpdate() 메서드 작성
					stmt.executeUpdate(sql);
					out.println("Member 테이블을 수정했습니다");
				} else
					out.println("일치하는 비밀번호가 아닙니다");
				} else
					out.println("member 테이블에 일치하는 아이디가 없습니다");
			} catch (SQLException ex) {
				out.println("SQLException: " + ex.getMessage());
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
		}
	%>
</body>
</html>