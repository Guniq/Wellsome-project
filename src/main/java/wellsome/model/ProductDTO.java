package wellsome.model;

import java.sql.Timestamp;

public class ProductDTO {
	private int pNum;
	private String pName;
	private String pCategory_fk;
	private String pImage;
	private int price;
	private int pQty;
	private String pSpec;
	private String pContent;
	private int pPoint;
	private Timestamp pInputDate;
	
	private int totPrice;
	private int totPoint;
	private int salePrice;
	
	public ProductDTO() {}

	public ProductDTO(String pName, String pCategory_fk, String pImage, int price, int pQty, String pSpec,
			String pContent, int pPoint, int totPrice, int totPoint, int salePrice) {
		super();
		this.pName = pName;
		this.pCategory_fk = pCategory_fk;
		this.pImage = pImage;
		this.price = price;
		this.pQty = pQty;
		this.pSpec = pSpec;
		this.pContent = pContent;
		this.pPoint = pPoint;
		this.totPrice = totPrice;
		this.totPoint = totPoint;
		this.salePrice = salePrice;
	}

	public ProductDTO(int pNum, String pName, String pCategory_fk, String pImage, int price, int pQty, String pSpec,
			String pContent, int pPoint, Timestamp pInputDate) {
		super();
		this.pNum = pNum;
		this.pName = pName;
		this.pCategory_fk = pCategory_fk;
		this.pImage = pImage;
		this.price = price;
		this.pQty = pQty;
		this.pSpec = pSpec;
		this.pContent = pContent;
		this.pPoint = pPoint;
		this.pInputDate = pInputDate;
	}
	
	public ProductDTO(int pNum, String pName, String pCategory_fk, String pImage, int price, int pQty, String pSpec,
			String pContent, int pPoint) {
		super();
		this.pNum = pNum;
		this.pName = pName;
		this.pCategory_fk = pCategory_fk;
		this.pImage = pImage;
		this.price = price;
		this.pQty = pQty;
		this.pSpec = pSpec;
		this.pContent = pContent;
		this.pPoint = pPoint;
	}
	
	public ProductDTO(String pName, String pCategory_fk, String pImage, int price, int pQty, String pSpec,
			String pContent, int pPoint) {
		super();
		this.pName = pName;
		this.pCategory_fk = pCategory_fk;
		this.pImage = pImage;
		this.price = price;
		this.pQty = pQty;
		this.pSpec = pSpec;
		this.pContent = pContent;
		this.pPoint = pPoint;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpCategory_fk() {
		return pCategory_fk;
	}

	public void setpCategory_fk(String pCategory_fk) {
		this.pCategory_fk = pCategory_fk;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
		
		totPrice = this.pQty*price;
		totPoint = this.pQty*pPoint;
	}

	public String getpSpec() {
		return pSpec;
	}

	public void setpSpec(String pSpec) {
		this.pSpec = pSpec;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public int getpPoint() {
		return pPoint;
	}

	public void setpPoint(int pPoint) {
		this.pPoint = pPoint;
	}

	public Timestamp getpInputDate() {
		return pInputDate;
	}

	public void setpInputDate(Timestamp pInputDate) {
		this.pInputDate = pInputDate;
	}

	public int getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(int totPrice) {
		this.totPrice = totPrice;
	}

	public int getTotPoint() {
		return totPoint;
	}

	public void setTotPoint(int totPoint) {
		this.totPoint = totPoint;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	@Override
	public String toString() {
		return "ProductDTO [pNum=" + pNum + ", pName=" + pName + ", pCategory_fk=" + pCategory_fk + ", pImage=" + pImage
				+ ", price=" + price + ", pQty=" + pQty + ", pSpec=" + pSpec + ", pContent=" + pContent + ", pPoint="
				+ pPoint + ", pInputDate=" + pInputDate + ", totPrice=" + totPrice + ", totPoint=" + totPoint
				+ ", salePrice=" + salePrice + "]";
	}

	
	
}
