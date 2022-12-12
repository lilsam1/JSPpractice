<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="member.js"></script>
<script src="https://spi.maps.daum.net/imap/map_js_init/postcode.v2.js"></script>
</head>
<body>
	<h3>회원가입</h3>
	<form  name="member_insert" id="member_insert">
		<p> 회원 아이디 : <input type="text" name="memberID" >
		<p> 비밀번호 : <input type="password" name="passwd" >
		<p> 비밀번호확인 : <input type="password" name="passwdcheck" >
		<p> 이름 : <input type="text" name="memberName" >
		<p> 이메일 : <input type="text" name="email">
		<p> 관심사항 : 영화<input type="checkbox" name="interest" value="영화" checked>
				독서<input type="checkbox" name="interest" value="독서">
				수영<input type="checkbox" name="interest" value="수영">
				등산<input type="checkbox" name="interest" value="등산">
		<p> 우편번호 : <input name="zipCode" id="zipcode" size="10" maxlength="7" readonly>
				<span onclick="execDaumPostcode();" style="cursor:pointer;">우편번호 검색</span>
		<p>	주소	<input name="address1" id="address01" size="70" maxlength="70" readonly>
		<p>	상세주소	<input name="address2" id="address02" size="70" maxlength="70">
		<p> 생년월일 : <input type="text" maxlength="4" size="4" name="birthYear">
				- <input type="text" maxlength="2" size="4" name="birthMonth">
				- <input type="text" maxlength="2" size="4" name="birthDay">
		<p> 메일 수신 여부 : <input type="radio" name="mailYN" value="yes" checked>yes
				<input type="radio" name="mailYN" value="no">no
		<p> 문자 수신 여부 : <input type="radio" name="smsYN" value="yes" checked>yes
				<input type="radio" name="smsYN" value="no">no		
		<p> <input type="button" id="button" value="회원 가입">
		
	</form>
</body>
</html>