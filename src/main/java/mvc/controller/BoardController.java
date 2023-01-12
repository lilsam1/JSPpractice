package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.model.BoardDAO;
import mvc.model.BoardDTO;

public class BoardController extends HttpServlet {
	static final int LISTCOUNT = 5;	// 페이지당 게시물 수

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	// get으로 넘어온 것을 post로 넘김
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String RequestURI = request.getRequestURI();	// 전체 경로를 가져옴
		String contextPath = request.getContextPath();	// 프로젝트 path만 가져옴
		String command = RequestURI.substring(contextPath.length());	// 전체 경로에서 프로젝트 Path 길이 만큼의 인덱스 이후의 문자열을 가져옴
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println(command);
		
		if (command.contains("/BoardListAction.do")) {	// 등록된 글 목록 페이지 출력
			requestBoardList(request);
			RequestDispatcher rd = request.getRequestDispatcher("../board/list.jsp");
			rd.forward(request,response);
		}
		else if (command.contains("/BoardWriteForm.do")) {	// 글 등록 페이지 출력
			requestLoginName(request);
			RequestDispatcher rd = request.getRequestDispatcher("../board/writeForm.jsp");
			rd.forward(request, response);
		}
		else if (command.contains("/BoardWriteAction.do")) {	// 새로운 글 등록
			requestBoardWrite(request);
			RequestDispatcher rd = request.getRequestDispatcher("../board/BoardListAction.do");
			rd.forward(request, response);
		}
	}
	// 인증된 사용자만 가져오기
	public void requestLoginName(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		String name = dao.getLoginNameById(id);
		
		request.setAttribute("name", name);
	}
	
	// 새로운 글 등록하기
	public void requestBoardWrite(HttpServletRequest request) {
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO board = new BoardDTO();
		board.setId(request.getParameter("id"));
		board.setName(request.getParameter("name"));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		
		// 확인용
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("subject"));
		System.out.println(request.getParameter("content"));
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
		String regist_day = formatter.format(new java.util.Date());
		
		board.setHit(0);
		board.setRegist_day(regist_day);
		board.setIp(request.getRemoteAddr());
		
		dao.insertBoard(board);	
	}
	
	// 등록된 글 목록 가져오기
	public void requestBoardList(HttpServletRequest request) {
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		
		int pageNum = 1;	// 페이지 번호가 전달이 안되면 1페이지 보여주도록
		int limit=LISTCOUNT;	// 페이지당 게시물 수
		
		if(request.getParameter("pageNum")!=null)	//페이지 번호가 전달이 된 경우
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		
		String items = request.getParameter("items");	// 검색 필드
		String text = request.getParameter("text");		// 검색어
		
		int total_record = dao.getListCount(items, text);	// 전체 게시물 숫자
		boardlist = dao.getBoardList(pageNum, limit, items, text);	// 현재 페이지에 해당하는 목록 데이터 가져오기
		
		int total_page;
		
		if (total_record % limit == 0) {	// 전체 게시물의 limit의 배수일 때
			total_page = total_record/limit;
			Math.floor(total_page);
		}
		else {
			total_page = total_record/limit;
			Math.floor(total_page);
			total_page = total_page + 1;
		}
		
		request.setAttribute("pageNum", pageNum);	// 페이지 번호
		request.setAttribute("total_page", total_page);	// 전체 페이지 숫자
		request.setAttribute("total_record", total_record);	// 전체 게시물 숫자
		request.setAttribute("boardlist", boardlist);
	}
	
}
