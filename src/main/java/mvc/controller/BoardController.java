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
	static final int LISTCOUNT = 5;	// �������� �Խù� ��

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	// get���� �Ѿ�� ���� post�� �ѱ�
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String RequestURI = request.getRequestURI();	// ��ü ��θ� ������
		String contextPath = request.getContextPath();	// ������Ʈ path�� ������
		String command = RequestURI.substring(contextPath.length());	// ��ü ��ο��� ������Ʈ Path ���� ��ŭ�� �ε��� ������ ���ڿ��� ������
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println(command);
		
		if (command.contains("/BoardListAction.do")) {	// ��ϵ� �� ��� ������ ���
			requestBoardList(request);
			RequestDispatcher rd = request.getRequestDispatcher("../board/list.jsp");
			rd.forward(request,response);
		}
		else if (command.contains("/BoardWriteForm.do")) {	// �� ��� ������ ���
			requestLoginName(request);
			RequestDispatcher rd = request.getRequestDispatcher("../board/writeForm.jsp");
			rd.forward(request, response);
		}
		else if (command.contains("/BoardWriteAction.do")) {	// ���ο� �� ���
			requestBoardWrite(request);
			RequestDispatcher rd = request.getRequestDispatcher("../board/BoardListAction.do");
			rd.forward(request, response);
		}
	}
	// ������ ����ڸ� ��������
	public void requestLoginName(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		String name = dao.getLoginNameById(id);
		
		request.setAttribute("name", name);
	}
	
	// ���ο� �� ����ϱ�
	public void requestBoardWrite(HttpServletRequest request) {
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO board = new BoardDTO();
		board.setId(request.getParameter("id"));
		board.setName(request.getParameter("name"));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		
		// Ȯ�ο�
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
	
	// ��ϵ� �� ��� ��������
	public void requestBoardList(HttpServletRequest request) {
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		
		int pageNum = 1;	// ������ ��ȣ�� ������ �ȵǸ� 1������ �����ֵ���
		int limit=LISTCOUNT;	// �������� �Խù� ��
		
		if(request.getParameter("pageNum")!=null)	//������ ��ȣ�� ������ �� ���
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		
		String items = request.getParameter("items");	// �˻� �ʵ�
		String text = request.getParameter("text");		// �˻���
		
		int total_record = dao.getListCount(items, text);	// ��ü �Խù� ����
		boardlist = dao.getBoardList(pageNum, limit, items, text);	// ���� �������� �ش��ϴ� ��� ������ ��������
		
		int total_page;
		
		if (total_record % limit == 0) {	// ��ü �Խù��� limit�� ����� ��
			total_page = total_record/limit;
			Math.floor(total_page);
		}
		else {
			total_page = total_record/limit;
			Math.floor(total_page);
			total_page = total_page + 1;
		}
		
		request.setAttribute("pageNum", pageNum);	// ������ ��ȣ
		request.setAttribute("total_page", total_page);	// ��ü ������ ����
		request.setAttribute("total_record", total_record);	// ��ü �Խù� ����
		request.setAttribute("boardlist", boardlist);
	}
	
}
