package servlet;


import java.io.FileInputStream;
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
import javax.servlet.http.Part;

import manager.HostShareManager;
import model.FileInfo;
import model.GroupInfoList;
import converter.PPTConvertImage;
import dbmanager.ShareDBManager;
/**
 * Servlet implementation class HostSharePageServlet
 */
@WebServlet(urlPatterns = { "/go_to_share_page.do", "/choose_file.do", "/select_file.do", "/start_share.do"})
@MultipartConfig
public class HostSharePageServlet extends HttpServlet {
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
		
	
		if(action.equals("go_to_share_page.do")){
			dispatchUrl = "page/share_page_step_1.jsp";
		}
		
		
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
		
		System.out.println(uri);
		
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		String dispatchUrl = null;
	
		if( action.equals("choose_file.do")){
			this.chooseFile(request, response);
			dispatchUrl = "page/share_page_step_1.jsp";
			//response.sendRedirect("page/share_page_step_1.jsp");
		}
		else if( action.equals("select_file.do") ){
			this.saveFile(request, response);
			dispatchUrl = "page/share_page_step_2.jsp";
			//response.sendRedirect("page/share_page_step_2.jsp");
		}
		else if( action.equals("start_share.do") ){
			this.startShare(request, response);
			dispatchUrl = "page/share_page_host.jsp";
		}
		
		if( dispatchUrl != null ){
			RequestDispatcher view = request.getRequestDispatcher(dispatchUrl);
			view.forward(request, response);
			//response.sendRedirect("../page/share_page_step_2.jsp");
		}
	}
	
	private void chooseFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("filename");
		System.out.println(part);
		String fileName = this.getFilename(part);
		
		if( fileName != null && !fileName.isEmpty()){
			System.out.println("���� : " + fileName);
			//part.write(getServletContext().getRealPath("\\WEB-INF") + "\\" + fileName);
		}
		else{
			System.out.println("�������� ����");
			return ;
		}
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		String path = getServletContext().getRealPath("\\saveFile");
		PPTConvertImage converter = new PPTConvertImage((FileInputStream)part.getInputStream(), memberId, fileName, "jpg", path);
		
		converter.createMemberDirectory();
		converter.createPptFileDirectory();
		
		String fileForm = fileName.substring(fileName.lastIndexOf('.')+1);
		
		if( fileForm.equals("ppt") ){
			converter.pptConvter(1);
		}
		else if( fileForm.equals("pptx") ){
			converter.pptxConvter(1);
		}
		else{
			System.out.println("PPT������ �ƴմϴ�.");
		}
		
		///////////////////////////////Path �����κ�//////////////////////////////////
		String imagePath = "http://localhost:8089/project_v1/saveFile/" + memberId + "/" + fileName + "/1.jpg";
		
		request.setAttribute("imagePath", imagePath);
		//////////////////////////////////////////////////////////////////////////
		
		System.out.println("ChooseFile");
	}

	private void saveFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("filename");
		System.out.println(part);
		String fileName = this.getFilename(part);
		
		if( fileName != null && !fileName.isEmpty() && part.getSize() > 0){
			System.out.println("���� : " + fileName);
			//part.write(getServletContext().getRealPath("\\WEB-INF") + "\\" + fileName);
		}
		else{
			System.out.println("�������� ����");
			return ;
		}
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		String path = getServletContext().getRealPath("\\saveFile");
		PPTConvertImage converter = new PPTConvertImage((FileInputStream)part.getInputStream(), memberId, fileName, "jpg", path);
		
		converter.createMemberDirectory();
		converter.createPptFileDirectory();
		
		String fileForm = fileName.substring(fileName.lastIndexOf('.')+1);
		
		if( fileForm.equals("ppt") ){
			converter.pptConvter(0);
		}
		else if( fileForm.equals("pptx") ){
			converter.pptxConvter(0);
		}
		else{
			System.out.println("PPT������ �ƴմϴ�.");
			return ;
		}
		
		//////////////////////////��� ppt -> image ���� �Ϸ�/////////////////////////
		
		String fileAddress = path + "\\" + memberId + "\\" + fileName;
		//String fileAddress = "saveFile\\"+memberId + "\\" + fileName;
		System.out.println("HostSharePageServlet 179 Line : "+fileAddress);
		double fileSize = (double)part.getSize();
		
		FileInfo fileInfo = new FileInfo(null, fileAddress, fileName, fileForm, fileSize);
		
		ShareDBManager shareDBManager = new ShareDBManager();
		
		String fileCode = shareDBManager.saveFile(memberId, fileInfo);
				
		///////////////////////////DB�� �������� ���� �Ϸ�////////////////////////////////////
		
		int maxPageNum = converter.checkMaxPageNum(path, memberId, fileName);
		System.out.println("�� ������ �� : " + maxPageNum);
		
		/////////////////// �ѷ��� �׷����� �������°ź��� ����..!!!!!!!!!!!!!!!!!!! //////////////////
		
		HostShareManager hsm = new HostShareManager();
		
		GroupInfoList groupList = hsm.watchGroup(memberId);
		
		request.setAttribute("groupList", groupList);
		request.setAttribute("fileCode", fileCode);
		
		System.out.println("�̰��ΰ�?"+request.getParameter("imagePath"));
		request.setAttribute("imagePath", request.getParameter("imagePath"));
		
		System.out.println("saveFile");
	}
	
	private void startShare(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.inviteMember(request, response);
		
		HttpSession session = request.getSession();
		String memberId=(String)session.getAttribute("memberId");
		
		String imgPath = request.getParameter("imagePath");
		int lastIndex = imgPath.lastIndexOf("/");
		System.out.println("im ; "+imgPath);
		System.out.println("last Index : "+lastIndex);
		String path = imgPath.substring(0, lastIndex);  // ppt�̸� ���� �� ���
		System.out.println("path , "+path);
		int li = path.lastIndexOf("/");
		String fileName = path.substring(li+1);  // ���� �̸�
		String ProPath = getServletContext().getRealPath("\\saveFile");
		PPTConvertImage converter = new PPTConvertImage();
		int maxNum = converter.checkMaxPageNum(ProPath, memberId, fileName); // �ش� ppt�� �� �����̵� ����
		
		ArrayList<String> paths = new ArrayList<String>(); // �̹��� ����� ����Ʈ��..
		for(int i=1; i<maxNum+1; i++)
			paths.add(path+"/"+i+".jpg");
		request.setAttribute("paths", paths); // host�ʿ� ����
		request.setAttribute("path", path); // guest�ʿ� ���� ��
		request.setAttribute("maxNum", maxNum); // �ִ� ������ ��
		System.out.println("startShare");
	}
	
	private void inviteMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] inviteIds = request.getParameterValues("inviteIds");
		ArrayList<String> inviteIdList = new ArrayList<String>();
		
		for(String temp:inviteIds){
			System.out.println("invite ID : "+temp);
			inviteIdList.add(temp);
		}
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		String fileCode = request.getParameter("fileCode");
		
		HostShareManager hsm = new HostShareManager();
		System.out.println("memberId : "+memberId+",  fileCode : "+fileCode);
		
		String link = hsm.startShare(memberId, inviteIdList, fileCode);
		System.out.println("Host Share Page  link : "+link);
		request.setAttribute("link", link);
		//request.setAttribute("fileCode", fileCode);
		
		System.out.println("inviteMember");
	}


	private String getFilename(Part part) {
        String contentDispositionHeader = part.getHeader("content-disposition");
        String[] elements = contentDispositionHeader.split(";");
        
        for(String element:elements){
        	if( element.trim().startsWith("filename")){
        		return element.substring(element.indexOf('=')+1).trim().replace("\"", "");
        	}
        }
        
        return null;
    }
}
