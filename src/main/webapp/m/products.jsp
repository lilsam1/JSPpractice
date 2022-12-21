<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="market.dto.Product" %>
<jsp:useBean id="productDAO" class="market.dao.ProductRepository" scope="session" />
<!DOCTYPE html>
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css
" rel="stylesheet" >
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품목록</h1>
		</div>
	</div>
	<% 
		ArrayList<Product> listofProducts = productDAO.getAllProducts();
	%>
	
	<div class="container">
		<div class="row" align="center">
			<%
				for (int i = 0; i < listofProducts.size(); i++) {
					Product product = listofProducts.get(i);
			%>
			<div class="col-md-4">
				<h3><%=product.getPname()%></h3>
				<p><%=product.getDescription()%></p>
				<p><%=product.getUnitPrice()%>원
				<p><a href="./product.jsp?id=<%=product.getProductId()%>" class="btn btn-secondary" role="button">
				상세 정보 &raquo;</a>
			</div>
			<%
				}
			%>
		</div>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>