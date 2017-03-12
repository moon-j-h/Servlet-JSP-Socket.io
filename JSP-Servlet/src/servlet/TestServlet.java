package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name = "test", urlPatterns = { "/test" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//HttpSession se = request.getSession();
		//se.setAttribute("memberId", "moon");
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("memberId", "moon@naver.com");
		request.setAttribute("memberName", "¹®Á¤Çö");
		request.setAttribute("fileCode", 31);
		RequestDispatcher di = request.getRequestDispatcher("page/share_page_host.jsp");
		di.forward(request, response);
	}

}
