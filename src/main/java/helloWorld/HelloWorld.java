package helloWorld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// � ��û�� ���� ������ ȣ���� �������� �����ϴ� URL mapping �κе� urlPatterns �Ӽ����� ����
@WebServlet(description = "My first servlet", urlPatterns = {"/hello"})
public class HelloWorld extends HttpServlet {

	@Override
	// GET ��û�� ó���ϴ� �޼��� request, response�� ���ڷ� ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ���� ������ Ÿ�� ������ �ѱ� ����� ���� response.setContentType() �޼��� ���
		response.setContentType("text/html; charset=utf-8");
		// PrintWriter�� ��� ��Ʈ������ Ŭ���̾�Ʈ�� ������ ��¹� �ۼ��� ���
		// ��� ��Ʈ���� �̿��� HTML �������� �����Ϳ� ������ ���
		PrintWriter out = response.getWriter();
		out.append("<!doctype html><html><head><title>Hello World Servlet</title></head><body>")
		.append("<h2>Hellow World !</h2><hr>")
		.append("���� ��¥�� �ð���: " +java.time.LocalDateTime.now())
		.append("</body></html");
	}

	@Override
	// POST ��û�� ó���ϴ� �޼���
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// REST API ������ �ƴ� �Ϲ� ���� �����̶�� GET, POST�� ���������� �����ϰ� ó��
		doGet(request, response);
	}
	
}
