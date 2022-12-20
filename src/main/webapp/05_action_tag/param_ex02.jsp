<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	forward 액션 태그와 param 액션 태그에 제목과 현재 날짜 전달하기
	1) 외부 파일 param_ex02_date.jsp의 내용을 출력하도록 include 액션 태그의 page 속성을 작성
	2) 매개변수 title과 값을 전송하기 위해 param 액션 태그를 작성
	한글이 꺠지지 안호도록 java.net.URLEncoder.encode() 메서드를 사용
	3) 매개변수 date와 값을 전송하기 위해 param 액션 태그를 사용
	 --%>
	<h3>param 액션 태그</h3>
	<jsp:include page="param_ex02_date.jsp">
		<jsp:param name="title" value='<%=java.net.URLEncoder.encode("오늘의 날짜와 시각")%>' />
		<jsp:param name="date" value="<%=java.util.Calendar.getInstance().getTime()%>" />
	</jsp:forward>
	<p>Java Server Page
</body>
</html>