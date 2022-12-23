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
		MultipartRequest 클래스를 이용하여 다음 조건에 맞게 JSP 애플리케이션을 만들고 실행 결과 확인
		
		1) cos.jar 클래스를 사용
		2)fileuploadEx01.jsp 파일을 생성
		* input 태그 내에 file 유형을 이용하여 파일 항목 작성
		* form 태그의 action 속성 값은 fileuploadEx01_process.jsp로, enctype 속성 값은 multipart/form-data로 작성
		
		3)fileuploadEx01_process.jsp 파일을 생성
		* MultipartRequest 클래스를 사용하여 요청 파라미터 이름, 실제 파일 이름, 저장 파일 이름, 파일 컨텐츠 유형, 파일 크기를 출력
	 --%>
	<form action="fileuploadEx01_process.jsp" method="post" enctype="multipart/form-data">
		<p> <input type="file" name="filename">
		<p> <input type="submit" value="파일 올리기">
	</form>
</body>
</html>