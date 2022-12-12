<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* { margin: 0; padding: 0;}
	ul { list-style: none;}
	body { margin: 20px auto; width: 400px; }
</style>
</head>
<body>
	<div class="insert">
		<form>
			<input type="text" name="item">
			<input type="button" value="등록">
		</form>
	</div>
	<!-- 목록이 들어갈 부분 -->
	<div id="todo_list">
	<script>
		document.addEvnetLinstenr("DOMContentLoaded", function () {
			/* 변수 선언 */
			const xhr = new XHLHttpRequest();	// XMLHttpRequest 객체 생성
			
			/* 함수 선언 */
			const insertItem = function (num, item) {
				/* 목록에 요소를 추가. 처음 로딩시 목록을 출력하거나 새로운 글 등록시 사용*/
				let tagNew = document.createElement('li');
				tagNew.innerHTML = "<label><input type="checkbox" class="cb" name="' + num + '" value="' + num + '"></label> ' + item;
				tagNew.setAttribute('class', num);
				// 동적으로 생성된 요소여서 생성시에 이벤트 추가
				tagNew.querySelector('input[type=checkbox]').addEventListener('click', deleteItem);
				let tagUl = document.querySelector('ul');
				tagUl.prepend(tagNew);
			}
		})
	</script>
	</div>

</body>
</html>