package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.model.BoardDAO;
import mvc.model.BoardDTO;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	static final int LISTCOUNT = 5;	// 占쏙옙占쏙옙占쏙옙占쏙옙 占쌉시뱄옙 占쏙옙

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	// get占쏙옙占쏙옙 占싼억옙占� 占쏙옙占쏙옙 post占쏙옙 占싼깍옙
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String RequestURI = request.getRequestURI();	// 占쏙옙체 占쏙옙罐占� 占쏙옙占쏙옙占쏙옙
		String contextPath = request.getContextPath();	// 占쏙옙占쏙옙占쏙옙트 path占쏙옙 占쏙옙占쏙옙占쏙옙
		String command = RequestURI.substring(contextPath.length());	// 占쏙옙체 占쏙옙恝占쏙옙占� 占쏙옙占쏙옙占쏙옙트 Path 占쏙옙占쏙옙 占쏙옙큼占쏙옙 占싸듸옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占쏙옙
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println(command);
		
		if (command.contains("/BoardListAction.do")) {	// 占쏙옙溝占� 占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占�
			requestBoardList(request);
			RequestDispatcher rd = request.getRequestDispatcher("../board/list.jsp");
			rd.forward(request,response);
		}
		else if (command.contains("/BoardWriteForm.do")) {	// 占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占�
			requestLoginName(request);
			RequestDispatcher rd = request.getRequestDispatcher("../board/writeForm.jsp");
			rd.forward(request, response);
		}
		else if (command.contains("/BoardWriteAction.do")) {	// 占쏙옙占싸울옙 占쏙옙 占쏙옙占�
			requestBoardWrite(request);
			RequestDispatcher rd = request.getRequestDispatcher("../board/BoardListAction.do");
			rd.forward(request, response);
		}
		else if (command.contains("/BoardViewAction.do")) {		// 占쏙옙占시듸옙 占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
			requestBoardView(request);
			RequestDispatcher rd = request.getRequestDispatcher("../board/BoardView.do");
			rd.forward(request, response);
		}
		else if (command.contains("/BoardView.do")) {		// 占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占�
			RequestDispatcher rd = request.getRequestDispatcher("../board/view.jsp");
			rd.forward(request, response);
		}
		else if (command.contains("/BoardUpdateAction.do")) {
			requestBoardUpdate(request);
			RequestDispatcher rd = request.getRequestDispatcher("../board/BoardListAction.do");
			rd.forward(request, response);
		}
		else if (command.contains("/BoardDeleteAction.do")) {	// 占쏙옙占시듸옙 占쏙옙 占쏙옙占쏙옙
			requestBoardDelete(request);	
			RequestDispatcher rd = request.getRequestDispatcher("../board/BoardListAction.do");
			rd.forward(request, response);
		}
		
	}
	// 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙美占� 占쏙옙占쏙옙占쏙옙占쏙옙
	public void requestLoginName(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		String name = dao.getLoginNameById(id);
		
		request.setAttribute("name", name);
	}
	
	// 占쏙옙占싸울옙 占쏙옙 占쏙옙占쏙옙歐占�
	public void requestBoardWrite(HttpServletRequest request) {
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO board = new BoardDTO();
		board.setId(request.getParameter("id"));
		board.setName(request.getParameter("name"));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		
		// 확占싸울옙
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
	
	// 占쏙옙占시듸옙 占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
	public void requestBoardView(HttpServletRequest request) {
		BoardDAO dao = BoardDAO.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		BoardDTO board = new BoardDTO();
		board = dao.getBoardByNum(num, pageNum);
		
		request.setAttribute("num", num);
		request.setAttribute("page", pageNum);
		request.setAttribute("board", board);
	}
	
	// 占쏙옙占시듸옙 占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占싹깍옙
	public void requestBoardUpdate(HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO board = new BoardDTO();
		board.setNum(num);
		board.setName(request.getParameter("name"));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		
		dao.updateBoard(board);
	}
	
	// 占쏙옙占시듸옙 占쏙옙 占쏙옙占쏙옙占싹깍옙
	public void requestBoardDelete(HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(num);
	}
	
	// 占쏙옙溝占� 占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙占쏙옙
	public void requestBoardList(HttpServletRequest request) {
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		
		int pageNum = 1;	// 占쏙옙占쏙옙占쏙옙 占쏙옙호占쏙옙 占쏙옙占쏙옙占쏙옙 占싫되몌옙 1占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌍듸옙占쏙옙
		int limit=LISTCOUNT;	// 占쏙옙占쏙옙占쏙옙占쏙옙 占쌉시뱄옙 占쏙옙
		
		if(request.getParameter("pageNum")!=null)	//占쏙옙占쏙옙占쏙옙 占쏙옙호占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占�
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		
		String items = request.getParameter("items");	// 占싯삼옙 占십듸옙
		String text = request.getParameter("text");		// 占싯삼옙占쏙옙
		
		int total_record = dao.getListCount(items, text);	// 占쏙옙체 占쌉시뱄옙 占쏙옙占쏙옙
		boardlist = dao.getBoardList(pageNum, limit, items, text);	// 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌔댐옙占싹댐옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
		
		int total_page;
		
		if (total_record % limit == 0) {	// 占쏙옙체 占쌉시뱄옙占쏙옙 limit占쏙옙 占쏙옙占쏙옙占� 占쏙옙
			total_page = total_record/limit;
			Math.floor(total_page);
		}
		else {
			total_page = total_record/limit;
			Math.floor(total_page);
			total_page = total_page + 1;
		}
		
		request.setAttribute("pageNum", pageNum);	// 占쏙옙占쏙옙占쏙옙 占쏙옙호
		request.setAttribute("total_page", total_page);	// 占쏙옙체 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
		request.setAttribute("total_record", total_record);	// 占쏙옙체 占쌉시뱄옙 占쏙옙占쏙옙
		request.setAttribute("boardlist", boardlist);
	}
	
}
