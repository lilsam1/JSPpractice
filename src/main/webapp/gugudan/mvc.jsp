<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>구구단</h2>
	<hr>
	<!-- 
	단이 되는 숫자를 입력하고 제출 버튼을 누르면 입력값을 서블릿으로 전달
	서블릿은 브라우저로 전달된 입력값을 가져와 계산 후 결과를 포함한 화면을 출력하는 구조
	
	입력 파라미터
	* n1 : 숫자 입력
	-->
	<form method="post" action="gugudancontroller">
		<p>구구단 :<input type="text" name="dan" size="10">
		<input type="submit" value="제출">
	</form>
</body>
</html>