package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.CommentManager;
import model.CommentInfo;
import model.CommentInfoList;
import model.ShareInfo;
import validator.CommentValidator;

import com.google.gson.Gson;

import converter.PPTConvertImage;
import form.CommentForm;
import form.RecommentForm;

/**
 * 
 * @author 문정현
 *
 */
@WebServlet(name = "Comment", urlPatterns = { "/watch_share_page.do", "/watch_comment.do", "/write_comment.do", "/delete_comment.do", "/update_comment.do", "/refresh_comment.do" })
public class CommentManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURI();  
		int lastIndex = url.lastIndexOf("/");
		String action = url.substring(lastIndex+1);
		
		if(action.equals("watch_comment.do")){
			this.watchComment(request, response);
		}else if(action.equals("watch_share_page.do")){
			this.watchSharePage(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String url = request.getRequestURI();
		//System.out.println(url);
		int lastIndex = url.lastIndexOf("/");
		String action = url.substring(lastIndex+1);
		
		if(action.equals("write_comment.do")){
			this.writeComment(request, response);
		}else if(action.equals("update_comment.do")){
			this.updateComment(request, response);
		}else if(action.equals("delete_comment.do")){
			this.deleteComment(request, response);
		}else if(action.equals("refresh_comment.do")){
			this.refreshComment(request, response);
		}
	}
	
	private void watchSharePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memberId");
		CommentManager manager = new CommentManager();
		ArrayList<ShareInfo> info = manager.watchSharePage(id);
		request.setAttribute("shareList", info);
		RequestDispatcher dis = request.getRequestDispatcher("page/comment_manage_1.jsp");
		dis.forward(request, response);
		
	}
	private void watchComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("fileCode");
		HttpSession se = request.getSession();
		se.setAttribute("fileCode", code);
		
		CommentManager manager = new CommentManager();
		CommentInfoList list = manager.watchComment(code, 1);
		
		list.sortComment();
		
		request.setAttribute("commentInfoList", list);
		
		// 파일 경로 가져오기
		String filePath = manager.getFileAddress(code);
		System.out.println("filePath : "+filePath);
		
		// 파일 개수 구하기
		
		int lastIndex = filePath.lastIndexOf("\\");
		System.out.println("lastIndex"+lastIndex);
		String fileName = filePath.substring(lastIndex+1);
		int secondIndex = filePath.lastIndexOf("\\", lastIndex-1);
		String hostId = filePath.substring(secondIndex+1, lastIndex);
		System.out.println(fileName + "=fileName,"+hostId + " =hostId");
		
		String path = getServletContext().getRealPath("\\saveFile");
		PPTConvertImage converter = new PPTConvertImage();
		int maxPageNum = converter.checkMaxPageNum(path, hostId, fileName);
		System.out.println("총 페이지 수 : " + maxPageNum);
		
		
		// request에 저장
		//request.setAttribute("filePath", "http://localhost:8089/DalGongFee/saveFile/"+hostId+"/"+fileName+"/");
		request.setAttribute("filePath", "saveFile/"+hostId+"/"+fileName+"/");
		request.setAttribute("maxPageNum", maxPageNum);
		RequestDispatcher dis = request.getRequestDispatcher("page/comment_manage_2.jsp");
		dis.forward(request, response);
	}
	private void refreshComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		String fileCode = (String)se.getAttribute("fileCode");
		String pageNum = request.getParameter("pageNum");
		
		CommentManager manager = new CommentManager();
		CommentInfoList list = null;
		if(pageNum!=null){ // 댓글 관리에서 사용
			list = manager.watchComment(fileCode, Integer.parseInt(pageNum));
			list.sortComment();
		}else{// 페이지 공유중 사용
			System.out.println("페이지 공유중임");
			list = manager.watchComment(fileCode);
		}
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String str = gson.toJson(list.getCommentInfoList());
		out.println(str);
	}
	private void writeComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		String id = (String)se.getAttribute("memberId");
		String fileCode = (String)se.getAttribute("fileCode");
		
		
		
		String parentCode = request.getParameter("parentCode");
		String pageNum = request.getParameter("pageNum");
		String content = request.getParameter("content");
		
		System.out.println(parentCode+" : "+pageNum+" : "+content);
		
		CommentValidator cv = new CommentValidator();
		CommentForm cf = null;
		RecommentForm rcf = null;
		boolean valiRes = false;
		CommentManager manager = new CommentManager();
		CommentInfo commentInfo = null;
		CommentInfoList list = null;
		
		if(parentCode == null){ // 그냥 댓글
			cf = new CommentForm(pageNum, content);
			valiRes = cv.validateCommentForm(cf);
			if(valiRes){
				commentInfo = new CommentInfo(null, id, content, null, fileCode, Integer.parseInt(pageNum));
				list = manager.writeComment(commentInfo);
			}else
				System.out.println("부적합");
		}else{  // 답글
			rcf = new RecommentForm(parentCode, pageNum, content);
			valiRes = cv.validateCommentForm(rcf);
			if(valiRes){
				commentInfo = new CommentInfo(parentCode, "", id, null, content, "", fileCode, Integer.parseInt(pageNum));
				list = manager.writeComment(commentInfo);
			}else
				System.out.println("부적합");
		}
		list.sortComment();  // 정렬
		System.out.println("write comment : "+list);
		Gson gson = new Gson();
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String str = gson.toJson(list.getCommentInfoList());
		System.out.println("json 표현 : "+str);
		out.println(str);
		
	}
	
	// 나중 구현
	private void deleteComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	private void updateComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
