package wellsome.model;

public class UserDTO {
	private int no;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String tel;
	private String zipcode;
	private String roadAddr;
	private String detailAddr;
	
	public UserDTO() {}

	public UserDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public UserDTO(String id, String pw, String name, String email, String tel, String zipcode, String roadAddr,
			String detailAddr) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.zipcode = zipcode;
		this.roadAddr = roadAddr;
		this.detailAddr = detailAddr;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getRoadAddr() {
		return roadAddr;
	}

	public void setRoadAddr(String roadAddr) {
		this.roadAddr = roadAddr;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	
	
	
}


