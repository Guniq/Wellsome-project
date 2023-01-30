package wellsome.model;

import java.sql.Timestamp;

public class BoardDTO {
	private int bNum;
	private String bTitle;
	private String bName;
	private String bContent;
	private Timestamp bDate;
	
	public BoardDTO() {}

	public BoardDTO(int bNum, String bTitle, String bName, String bContent, Timestamp bDate) {
		super();
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bName = bName;
		this.bContent = bContent;
		this.bDate = bDate;
	}
	public BoardDTO(int bNum, String bTitle, String bName, String bContent) {
		super();
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bName = bName;
		this.bContent = bContent;
	}
	
	public BoardDTO(String bTitle, String bName, String bContent) {
		super();
		this.bTitle = bTitle;
		this.bName = bName;
		this.bContent = bContent;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	@Override
	public String toString() {
		return "BoardDTO [bNum=" + bNum + ", bTitle=" + bTitle + ", bName=" + bName + ", bContent=" + bContent
				+ ", bDate=" + bDate + "]";
	}
	
	
}
