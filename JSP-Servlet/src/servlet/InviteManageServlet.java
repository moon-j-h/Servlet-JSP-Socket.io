package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.InviteManager;
import model.InviteInfo;

/**
 * Servlet implementation class InviteManageServlet
 */
@WebServlet(urlPatterns = {"/watch_invite.do", "/accept_invite.do", "/refuse_invite.do"})
@MultipartConfig
public class InviteManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		String dispatchUrl = null;

		if( action.equals("watch_invite.do")){
			this.watchInvite(request, response);
		}
		
		dispatchUrl = "page/invite_manage.jsp";
		
		if( dispatchUrl != null ){
			RequestDispatcher view = request.getRequestDispatcher(dispatchUrl);
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		String dispatchUrl = null;

		if( action.equals("accept_invite.do")){
			String link = this.acceptInvite(request, response);
			// Redirect를 통해서 Link로 접속하도록 해줘야할 듯
			System.out.println("inviteManageServlet의 link : "+link);
			request.setAttribute("roomNum", link);
			int index = link.indexOf("-");
			String fileCode = link.substring(index+1);
			HttpSession se = request.getSession();
			se.setAttribute("fileCode", fileCode);
			dispatchUrl = "page/share_page_guest.jsp";
			
		}
		else if( action.equals("refuse_invite.do") ){
			this.refuseInvite(request, response);
			dispatchUrl = "page/invite_manage.jsp";
		}
		
		
		
		if( dispatchUrl != null ){
			RequestDispatcher view = request.getRequestDispatcher(dispatchUrl);
			view.forward(request, response);
		}
	}

	private void watchInvite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		
		InviteManager im = new InviteManager();
		ArrayList<InviteInfo> inviteList = im.watchInvite(memberId);
		
		request.setAttribute("inviteList", inviteList);
		
		System.out.println("watchInvite()");
	}
	
	private String acceptInvite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inviteCode = request.getParameter("inviteCode");

		InviteManager im = new InviteManager();
		String link = im.acceptInvite(inviteCode);
		// link로  redirect시켜줘야하지 않나요?
		
		this.watchInvite(request, response);
		System.out.println("acceptInvite()");
		
		return link;
	}
	
	private void refuseInvite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String inviteCode = request.getParameter("inviteCode");
		
		InviteManager im = new InviteManager();
		im.refuseInvite(inviteCode);
				
		this.watchInvite(request, response);
		System.out.println("refuseInvite()");
	}
}
