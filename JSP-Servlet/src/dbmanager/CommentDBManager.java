package dbmanager;

import java.util.ArrayList;
import java.util.List;

import model.CommentInfo;
import model.CommentInfoList;
import model.FileInfo;
import model.ShareInfo;
import dao.tb.CommentDAO;
import dao.view.CommentInfoDAO;
import dao.view.ShareInfoDAO;
import dto.tb.CommentDTO;
import dto.view.CommentInfoDTO;
import dto.view.ShareInfoDTO;
/**
 * 
 * @author ������
 *
 */
public class CommentDBManager {
	private CommentDAO commentDAO;
	private CommentInfoDAO commentInfoDAO;
	private ShareInfoDAO shareInfoDAO;
	public CommentDBManager(){
		this.commentDAO = new CommentDAO();
		this.commentInfoDAO = new CommentInfoDAO();
		this.shareInfoDAO = new ShareInfoDAO();
	}
	public CommentDBManager(CommentDAO commentDAO,
			CommentInfoDAO commentInfoDAO, ShareInfoDAO shareInfoDAO) {
		this.commentDAO = commentDAO;
		this.commentInfoDAO = commentInfoDAO;
		this.shareInfoDAO = shareInfoDAO;
	}
	public CommentDBManager(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
		this.commentInfoDAO = new CommentInfoDAO();
		this.shareInfoDAO = new ShareInfoDAO();
	}
	public CommentDBManager(CommentInfoDAO commentInfoDAO) {
		this.commentInfoDAO = commentInfoDAO;
		this.commentDAO = new CommentDAO();
		this.shareInfoDAO = new ShareInfoDAO();
	}
	public CommentDBManager(ShareInfoDAO shareInfoDAO) {
		this.shareInfoDAO = shareInfoDAO;
		this.commentDAO = new CommentDAO();
		this.commentInfoDAO = new CommentInfoDAO();
	}
	public CommentDAO getCommentDAO() {
		return commentDAO;
	}
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	public CommentInfoDAO getCommentInfoDAO() {
		return commentInfoDAO;
	}
	public void setCommentInfoDAO(CommentInfoDAO commentInfoDAO) {
		this.commentInfoDAO = commentInfoDAO;
	}
	public ShareInfoDAO getShareInfoDAO() {
		return shareInfoDAO;
	}
	public void setShareInfoDAO(ShareInfoDAO shareInfoDAO) {
		this.shareInfoDAO = shareInfoDAO;
	}
	public ArrayList<ShareInfo> selectSharePage(String id){
		MemberDBManager manager = new MemberDBManager();
		int code = manager.selectMemberCode(id);
		List<ShareInfoDTO> info = this.shareInfoDAO.selectShareInfo(code);
		ArrayList<ShareInfo> res = new ArrayList<ShareInfo>();
		for(ShareInfoDTO temp : info){
			res.add(new ShareInfo(temp.getHostId(), temp.getHostName(), "", 0, null, temp.getShareDate(), new FileInfo(Integer.toString(temp.getFileCode()))));
		}
		return res;
	}
	public CommentInfoList selectComment(String fileCode, int pageNum){
		List<CommentInfoDTO> dto = this.commentInfoDAO.selectCommentInfo(Integer.parseInt(fileCode), pageNum);
		CommentInfoList list = new CommentInfoList();
		for(CommentInfoDTO temp : dto){
			if(temp.getSuperCommentCode() == 0)
				list.addCommentInfo(null, Integer.toString(temp.getCommentCode()), temp.getWriterId(), temp.getWriterName(), temp.getCommentContent(), temp.getWriteDate(), temp.getSlidePageNumber(), Integer.toString(temp.getFileCode()));
			else
				list.addCommentInfo(Integer.toString(temp.getSuperCommentCode()), Integer.toString(temp.getCommentCode()), temp.getWriterId(), temp.getWriterName(), temp.getCommentContent(), temp.getWriteDate(), temp.getSlidePageNumber(), Integer.toString(temp.getFileCode()));
		}
		return list;
	}
	public CommentInfoList selectComment(String fileCode){
		List<CommentInfoDTO> dto = this.commentInfoDAO.selectCommentInfo(Integer.parseInt(fileCode));
		CommentInfoList list = new CommentInfoList();
		for(CommentInfoDTO temp : dto){
			if(temp.getSuperCommentCode() == 0)
				list.addCommentInfo(null, Integer.toString(temp.getCommentCode()), temp.getWriterId(), temp.getWriterName(), temp.getCommentContent(), temp.getWriteDate(), temp.getSlidePageNumber(), Integer.toString(temp.getFileCode()));
			else
				list.addCommentInfo(Integer.toString(temp.getSuperCommentCode()), Integer.toString(temp.getCommentCode()), temp.getWriterId(), temp.getWriterName(), temp.getCommentContent(), temp.getWriteDate(), temp.getSlidePageNumber(), Integer.toString(temp.getFileCode()));
		}
		//////////
		System.out.println("dbmanager���� : "+list);
		return list;
	}
	public CommentInfoList insertComment(CommentInfo commentInfo){
		MemberDBManager manager = new MemberDBManager();
		int code = manager.selectMemberCode(commentInfo.getWriterId());
		String superCommentCode = commentInfo.getParentCommentCode();
		
		// �ڵ� ����
		//ArrayList<Integer> codes = (ArrayList<Integer>)this.commentDAO.selectCodes();
		//int lastCode = codes.get(codes.size()-1);
		
		CommentDTO dto = null;
		if(superCommentCode == null)  // ���
			dto = new CommentDTO(0, Integer.parseInt(commentInfo.getFileCode()), commentInfo.getPageNum(), code, commentInfo.getCommentContent(), null, 0);
		else // ���
			dto = new CommentDTO(0, Integer.parseInt(commentInfo.getFileCode()), commentInfo.getPageNum(), code, commentInfo.getCommentContent(), null, Integer.parseInt(superCommentCode));
		System.out.println("dbmanager�� insert : "+commentInfo.getFileCode());
		this.commentDAO.insertComment(dto);
		// �Ḹ.. �ϴ� �̰� ���� �ڵ�� ������ �� �޴� �ַ� �ؾ����� �ʳ�?
		return this.selectComment(commentInfo.getFileCode());
	}
	public CommentInfoList deleteComment(String commentCode){
		int fileCode = this.commentDAO.selectComment(Integer.parseInt(commentCode)).getFileCode();
		this.commentDAO.deleteComment(Integer.parseInt(commentCode));
		return this.selectComment(Integer.toString(fileCode));
	}
	public CommentInfoList updateComment(String commentCode, CommentInfo commentInfo){
		int fileCode = this.commentDAO.selectComment(Integer.parseInt(commentCode)).getFileCode();
		this.commentDAO.updateContent(Integer.parseInt(commentCode), commentInfo.getCommentContent());
		return this.selectComment(Integer.toString(fileCode));
	}
	public String selectFileAddress(String fileCode){
		ShareDBManager share = new ShareDBManager();
		return share.getFileAddress(fileCode);
	}
}
