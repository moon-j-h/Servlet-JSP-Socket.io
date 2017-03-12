package model;

import java.io.Serializable;

/**
 * 
 * @author ¹®Á¤Çö
 *
 */
public class ShareInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8739637590384849567L;
	private String hostId;
	private String hostName;
	private String link;
	private int maxJoiner;
	private JoinerList joinerList;
	private int nowPageNum;
	private String shareDate;
	private FileInfo fileInfo;
	public ShareInfo(String hostId, String hostName, String link,
			int maxJoiner, JoinerList joinerList, int nowPageNum,
			String shareDate, FileInfo fileInfo) {
		this.hostId = hostId;
		this.hostName = hostName;
		this.link = link;
		this.maxJoiner = maxJoiner;
		this.joinerList = joinerList;
		this.nowPageNum = nowPageNum;
		this.shareDate = shareDate;
		this.fileInfo = fileInfo;
	}
	public ShareInfo(String hostId, String hostName, String link,
			int maxJoiner, JoinerList joinerList, String shareDate,
			FileInfo fileInfo) {
		this.hostId = hostId;
		this.hostName = hostName;
		this.link = link;
		this.maxJoiner = maxJoiner;
		this.joinerList = joinerList;
		this.nowPageNum = 0;
		this.shareDate = shareDate;
		this.fileInfo = fileInfo;
	}
	public ShareInfo(String hostId, String hostName, String link,
			JoinerList joinerList, int nowPageNum, FileInfo fileInfo) {
		this.hostId = hostId;
		this.hostName = hostName;
		this.link = link;
		this.maxJoiner = 0;
		this.joinerList = joinerList;
		this.nowPageNum = nowPageNum;
		this.shareDate = "";
		this.fileInfo = fileInfo;
	}
	public ShareInfo(String hostId, String hostName, String link,
			JoinerList joinerList, FileInfo fileInfo) {
		this.hostId = hostId;
		this.hostName = hostName;
		this.link = link;
		this.maxJoiner = 0;
		this.joinerList = joinerList;
		this.nowPageNum = 0;
		this.shareDate = "";
		this.fileInfo = fileInfo;
	}
	public ShareInfo() {
		this.hostId = "";
		this.hostName = "";
		this.link = "";
		this.maxJoiner = 0;
		this.joinerList = new JoinerList();
		this.nowPageNum = 0;
		this.shareDate = "";
		this.fileInfo = new FileInfo();
	}
	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getMaxJoiner() {
		return maxJoiner;
	}
	public void setMaxJoiner(int maxJoiner) {
		this.maxJoiner = maxJoiner;
	}
	public JoinerList getJoinerList() {
		return joinerList;
	}
	public void setJoinerList(JoinerList joinerList) {
		this.joinerList = joinerList;
	}
	public int getNowPageNum() {
		return nowPageNum;
	}
	public void setNowPageNum(int nowPageNum) {
		this.nowPageNum = nowPageNum;
	}
	public String getShareDate() {
		return shareDate;
	}
	public void setShareDate(String shareDate) {
		this.shareDate = shareDate;
	}
	public FileInfo getFileInfo() {
		return fileInfo;
	}
	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}
	@Override
	public String toString() {
		return "ShareInfo [hostId=" + hostId + ", hostName=" + hostName
				+ ", link=" + link + ", maxJoiner=" + maxJoiner
				+ ", joinerList=" + joinerList + ", nowPageNum=" + nowPageNum
				+ ", shareDate=" + shareDate + ", fileInfo=" + fileInfo + "]";
	}
	
}
