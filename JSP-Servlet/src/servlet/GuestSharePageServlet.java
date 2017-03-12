package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GuestSharePageServlet
 */
@WebServlet(
		name = "GuestSharePage", 
		urlPatterns = { 
				"/connect_page.do"
		})
public class GuestSharePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		/*String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println("id : "+id+", name : "+name);
		HttpSession se = request.getSession();
		
		System.out.println("memberId : "+(String)se.getAttribute("memberId"));
		System.out.println("memberName : "+(String)se.getAttribute("memberName"));
		
		request.setAttribute("memberId", id);
		request.setAttribute("memberName", name);*/
		
		
		///////////////////////////////////////////////////////////////////////////////////////////
		HttpSession se = request.getSession();
		String roomNum = request.getParameter("link");  // 방 링크로 할려나?
		System.out.println("roomNum"+roomNum);
		request.setAttribute("roomNum", roomNum);
		int index = roomNum.indexOf("-");
		String fileCode = roomNum.substring(index+1);
		System.out.println("fileCOde -- guest : "+fileCode);
		se.setAttribute("fileCode", fileCode);
		RequestDispatcher dis = request.getRequestDispatcher("page/share_page_guest.jsp");
		dis.forward(request, response);
		
	}
/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}*/
	
}
