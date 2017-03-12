package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.CommentManager;
import manager.MemberManager;
import model.MemberInfo;
import model.ShareInfo;
import validator.MemberValidator;
import form.LoginForm;
/**
 * 
 * @author ������
 *
 */
@WebServlet(name = "Login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		LoginForm form = new LoginForm(id, pw);
		MemberValidator va = new MemberValidator();
		if(!va.validateLoginForm(form)){ // ������ �̰� �ʿ� ���� �ǵ�.. �ڹٽ�ũ��Ʈ �ʿ��� ��й�ȣ �ڸ��� üũ�� �ȸԾ .. ��
			request.setAttribute("error", "�ٽ� �õ� ���ּ���.");
			RequestDispatcher dis = request.getRequestDispatcher("page/login.jsp");
			dis.forward(request, response);
		}
		// �α��� Ȯ��
		MemberManager memMa = new MemberManager();
		MemberInfo memInfo = memMa.login(id, pw);
		if(memInfo == null){
			request.setAttribute("error", "�ٽ� �õ� ���ּ���.");
			RequestDispatcher dis = request.getRequestDispatcher("page/login.jsp");
			dis.forward(request, response);
		}else{
			// ���� ����
			HttpSession se = request.getSession();
			se.setAttribute("memberId", memInfo.getMemberId());
			se.setAttribute("memberName", memInfo.getMemberName());
		
			CommentManager manager = new CommentManager();
			ArrayList<ShareInfo> info = manager.watchSharePage(id);
			request.setAttribute("shareList", info);
			request.setAttribute("memberId", memInfo.getMemberId());
			request.setAttribute("memberName", memInfo.getMemberName());
			// ��� Ȯ�� ��������...
			RequestDispatcher dis = request.getRequestDispatcher("page/comment_manage_1.jsp");
			dis.forward(request, response);
		}
		
	}

}
