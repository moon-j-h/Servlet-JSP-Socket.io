package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.GroupManager;
import manager.HostShareManager;
import model.GroupInfoList;

/**
 * Servlet implementation class GroupManagerServlet
 */
@WebServlet(urlPatterns = { "/create_group.do", "/delete_group.do", "/add_member.do", "/delete_member.do", "/watch_group.do" })
@MultipartConfig
public class GroupManageServlet extends HttpServlet {
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
		
		if( action.equals("watch_group.do") ){
			System.out.println("너 왔니?");
			this.watchGroup(request, response);
		}
		
		dispatchUrl = "page/group_manage.jsp";
		
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

		if( action.equals("delete_group.do")){
			this.deleteGroup(request, response);
		}
		else if( action.equals("create_group.do") ){
			this.createGroup(request, response);
		}
		else if( action.equals("delete_member.do") ){
			this.deleteMember(request, response);
		}
		else if( action.equals("add_member.do") ){
			this.addMember(request, response);
		}
		
		
		dispatchUrl = "page/group_manage.jsp";
		
		if( dispatchUrl != null ){
			RequestDispatcher view = request.getRequestDispatcher(dispatchUrl);
			view.forward(request, response);
		}
	}

	private void createGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newGroupName = request.getParameter("groupname");
		
		System.out.println(newGroupName);
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		
		GroupManager gm = new GroupManager();
		
		int groupCode = gm.createGroup(memberId, newGroupName);
		System.out.println("new GroupCode : " + groupCode);
		gm.addGroupMember(Integer.toString(groupCode), memberId);
		
		this.watchGroup(request, response);
	}
	
	private void deleteGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String groupCode = request.getParameter("groupCode");
		
		GroupManager gm = new GroupManager();
		gm.deleteGroup(groupCode);
		
		this.watchGroup(request, response);
		
		System.out.println("deleteGroup()");
	}
	
	private void addMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberid");
		String groupCode = request.getParameter("groupcode");
		
		GroupManager gm = new GroupManager();
		if( gm.addGroupMember(groupCode, memberId) == null ){
			System.out.println("존재하지 않는 아이디");
			String errorMessage = "Nonexistent ID!!";
			request.setAttribute("errorMessage", errorMessage);
			return ;
		}
		
		this.watchGroup(request, response);
	}
	
	private void deleteMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String groupCode = request.getParameter("groupCode");
		String memberId = request.getParameter("memberId");
		
		//System.out.println(groupCode);
		//System.out.println(memberId);
		
		GroupManager gm = new GroupManager();
		gm.deleteGroupMember(groupCode, memberId);
		
		this.watchGroup(request, response);
	}
	
	private void watchGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		
		HostShareManager hsm = new HostShareManager();
		
		GroupInfoList groupList = hsm.watchGroup(memberId);
		
		System.out.println(memberId);
		System.out.println(groupList.getGroupInfoList().size());
		request.setAttribute("groupList", groupList);
	}
	
	
}
