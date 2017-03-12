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
 * @author 문정현
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
		if(!va.validateLoginForm(form)){ // 원래는 이건 필요 없는 건데.. 자바스크립트 쪽에서 비밀번호 자리수 체크가 안먹어서 .. 함
			request.setAttribute("error", "다시 시도 해주세요.");
			RequestDispatcher dis = request.getRequestDispatcher("page/login.jsp");
			dis.forward(request, response);
		}
		// 로그인 확인
		MemberManager memMa = new MemberManager();
		MemberInfo memInfo = memMa.login(id, pw);
		if(memInfo == null){
			request.setAttribute("error", "다시 시도 해주세요.");
			RequestDispatcher dis = request.getRequestDispatcher("page/login.jsp");
			dis.forward(request, response);
		}else{
			// 세션 저장
			HttpSession se = request.getSession();
			se.setAttribute("memberId", memInfo.getMemberId());
			se.setAttribute("memberName", memInfo.getMemberName());
		
			CommentManager manager = new CommentManager();
			ArrayList<ShareInfo> info = manager.watchSharePage(id);
			request.setAttribute("shareList", info);
			request.setAttribute("memberId", memInfo.getMemberId());
			request.setAttribute("memberName", memInfo.getMemberName());
			// 댓글 확인 페이지로...
			RequestDispatcher dis = request.getRequestDispatcher("page/comment_manage_1.jsp");
			dis.forward(request, response);
		}
		
	}

}
