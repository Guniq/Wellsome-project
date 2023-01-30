package wellsome.model;

public class CategoryDTO {
	private int num;
	private String code;
	private String name;
	
	public CategoryDTO() {}
	
	public CategoryDTO(int num, String code, String name) {
		super();
		this.num = num;
		this.code = code;
		this.name = name;
	}
	
	public CategoryDTO(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryDTO [num=" + num + ", code=" + code + ", name=" + name + "]";
	}
	
}
