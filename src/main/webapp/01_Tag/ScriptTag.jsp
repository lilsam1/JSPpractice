<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--주석 태그
JSP 주석 태그 comments tag : JSP 웹 컨테이너가 무시하는 텍스트를 표시
주석은 프로그램의 실행에는 영향을 미치지 않지만 프로그램의 이해 및 소스코드의 분석을 위해 반드시 기술할 것 권장

주석 태그는 JSP 웹 페이지에서만 사용되며, 웹 브라우저를 통해 해당 페이지의 출력 결과를 확인하거나
웹 브라우저상에서 소스 보기를 해도 주석 태그 내의 내용은 표시 되지 않음
 --%>

<%-- 스크립트 태그 
ㅇ선언문 태그 : 자바 변수나 메서드를 선언하는데 사용. 전역변수처럼 사용 가능(서블릿 프로그램으로 번역 시 클래스 수준의 멤버 변수가 되어서)
	   형식 : <%! 자바 코드; %>
ㅇ스크립틀릿 태그 : 자바 로직 코드를 작성하는데 사용. 서블릿 프로그램으로 변환시 _JspService()메서드 내부에 배치되어 지역변수 처럼 사용
	   형식 : <% 자바 코드; %>
ㅇ표현문 태그 : 변수, 계산식, 메서드 호출 결과를 문자열 형태로 출력하는데 사용
	   형식 : <%= 자바 코드; %> 
--%>

<%!
	// 선언문 태그를 사용하여 자바 변수와 메서드 정의
	int count = 3;
	String makeItLower(String data) {
		return data.toLowerCase();
	}
%>
<%
	// 스크립틀릿 태그로 자바 로직 코드 작성
	for (int i = 1; i <= count; i++) {
		out.println("java Server page" + i + ".<br>");
	}
%>
<%-- 표현문 태그로 선언문의 메서드를 호출하여 문자열 형태로 출력--%>
<%=makeItLower("Hello World")%>

</body>
</html>