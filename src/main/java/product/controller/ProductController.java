package product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.ProductService;

@WebServlet("/product/productController")
public class ProductController extends HttpServlet {
	ProductService service;
	
	public ProductController() {
		// �����ڿ��� �ʱ�ȭ. �� ��� ����� ��û�� ���� ������ �ν��Ͻ��� ���
		service = new ProductService();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Ŭ���̾�Ʈ ��û�� �����ϰ� ó�� �޼��带 ȣ���� ���� ��� �̵��ϴ� ������ �ۼ�
		String action = req.getParameter("action");
		String view = "";
//		System.out.println(action);
		if(action == null) {
			// action �Ķ���Ͱ� null�� ���  �� ������ action �Ķ���Ͱ� ���� ȣ��� ��� ��Ʈ�ѷ��� action �Ķ���͸� �־� ������
			// mvc ���������� jsp ȭ���� �ٷ� �����ϴ� ���� �ƴ϶� ��Ʈ�ѷ��� ���� JSP�� �̵��ؾ� �ϱ� ������
			// ������ ���Ǹ� ���� �۾�
			getServletContext().getRequestDispatcher("/product/productController?action=list").forward(req, resp);
		}
		else {
			// action �Ķ���� ���� ���� list, info �޼��带 ȣ��
			// �̋� request�� �ݵ�� �����ؾ� �Ķ���� ���� �о�� �� ������
			// response�� ��� ���� �ʿ������ Ȥ�� �ʿ��� ��츦 ����� �Բ� ����
			switch(action) {
				case "list":
					view = list(req,resp);break;
				case "info":
					view = info(req,resp);break;
			}
//			System.out.println(view);
			// ������ list() info()�޼��带 ������ �� ���ڿ��� �� JSP ���� �̸��� �����ϰ� ������
			getServletContext().getRequestDispatcher("/product/"+view).forward(req, resp);
		}
	}
	
	private String info(HttpServletRequest request, HttpServletResponse response) {
		// productList.jsp���� Ư�� ��ǰ�� �������� �� ȣ��Ǵ� �޼���
		// Ư�� ��ǰ�� ���� ������ ������ productInfo.jsp�� �̵��� ������
		request.setAttribute("product", service.find(request.getParameter("id")));
		return "productInfo.jsp";
	}
	
	private String list(HttpServletRequest request, HttpServletResponse response) {
		// ��ü �����͸� �����ֱ� ���� �޼���
		// service ��ü�� findAll() �޼��带 ȣ���� ����� request scope�� ����
		request.setAttribute("product", service.findAll());
		return "productList.jsp";
	}
	
}
