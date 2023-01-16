package gugudan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gugudan.model.Gugudan;

@WebServlet("/gugudan/gugudancontroller")
public class GugudanController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		
		String gugu = req.getParameter("gugu");
		
		Gugudan gugudan = new Gugudan();
		
		String result = gugudan.multiple(gugu);
		
		req.setAttribute("result", result);
		RequestDispatcher rd = req.getRequestDispatcher("../gugudan/result.jsp");
		rd.forward(req, resp);
	}

	
}
