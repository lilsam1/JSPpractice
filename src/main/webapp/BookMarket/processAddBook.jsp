<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="bookmarket.dto.Book" %>
<%@ page import="bookmarket.dao.BookRepository" %>

<%
	request.setCharacterEncoding("UTF-8");

	String booktid = request.getParameter("booktid");
	String name = request.getParameter("name");
	String unitPrice = request.getParameter("unitPrice");
	String author = request.getParameter("author");
	String description = request.getParameter("description");
	String publisher= request.getParameter("publisher");
	String category= request.getParameter("category");
	String unitsinStock = request.getParameter("unitsinStock");
	String totalPages = request.getParameter("totalPages");
	String releaseDate = request.getParameter("releaseDate");
	String condition = request.getParameter("condition");
	
	Integer price;
	
	if(unitPrice.isEmpty())
		price = 0;
	else
		price = Integer.valueOf(unitPrice);
	
	Integer pages;
	
	if (totalPages.isEmpty())
		pages = 0;
	else
		pages = Integer.valueOf(totalPages);
	
	long stock;
	
	if (unitsinStock.isEmpty())
		stock = 0;
	else
		stock = Long.valueOf(unitsinStock);
	
	BookRepository dao = BookRepository.getInstance();
	
	Book newBook = new Book();
	
	newBook.setBooktid(booktid);
	newBook.setName(name);
	newBook.setUnitPrice(price);
	newBook.setAuthor(author);
	newBook.setDescription(description);
	newBook.setPublisher(publisher);
	newBook.setCategory(category);
	newBook.setUnitsinStock(stock);
	newBook.setTotalPages(pages);
	newBook.setReleaseDate(releaseDate);
	newBook.setCondition(condition);
	
	dao.addBook(newBook);
	
	response.sendRedirect("books.jsp");
	
	
%>