package dbmanager;


import java.text.SimpleDateFormat;
import java.util.Date;

import model.FileInfo;
import dao.tb.FileDAO;
import dao.tb.ShareJoinerDAO;
import dto.tb.FileDTO;
import dto.tb.ShareJoinerDTO;

public class ShareDBManager {
	private FileDAO fileDAO;
	
	public ShareDBManager(){
		this.fileDAO = new FileDAO();
	}
	
	public ShareDBManager(FileDAO fileDAO){
		this.fileDAO = fileDAO;
	}

	public FileDAO getFileDAO() {
		return fileDAO;
	}

	public void setFileDAO(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}
	
	private boolean checkFileCode(int fileCode){
		FileDTO temp = this.fileDAO.selectFile(fileCode);
		
		if( temp == null ){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String saveFile(String hostId, FileInfo fileInfo){
		String fileCode = null;
		int randomCode = 0;
		
		while(true){
			randomCode = (int) (Math.random()*100000000);
			
			if( this.checkFileCode(randomCode) ){
				fileCode = Integer.toString(randomCode).trim(); 
				break;
			}
		}
		
		fileInfo.setFileCode(fileCode);
		
		int memberCode = new MemberDBManager().selectMemberCode(hostId);
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		FileDTO fileDTO = new FileDTO(randomCode, memberCode, fileInfo.getFileAddress(), fileInfo.getFileName(), sdf.format(d));
		
		this.fileDAO.insertFile(fileDTO);
		
		return fileCode;
	}
	
	public boolean insertShareJoiner(String fileCode, String joinerId){
		ShareJoinerDAO sjdao = new ShareJoinerDAO();
		int shareCode = 0;
		
		while(true){
			shareCode = (int) (Math.random()*100000000);
			
			if( sjdao.selectShareJoiner(shareCode) == null ){
				break;
			}
		}
		
		int memberCode = new MemberDBManager().selectMemberCode(joinerId);
		int intFileCode = Integer.parseInt(fileCode.trim());
		
		int res = sjdao.insertShareJoiner(new ShareJoinerDTO(shareCode, intFileCode, memberCode));
		
		if( res > 0 ){
			return true;
		}
		return false;
	}
	
	public boolean updateInviteState(String fileCode){
		return false;
	}
	
	///// Ãß°¡
	public String getFileAddress(String fileCode){
		return this.fileDAO.selectFileAddress(Integer.parseInt(fileCode));
	}
}
