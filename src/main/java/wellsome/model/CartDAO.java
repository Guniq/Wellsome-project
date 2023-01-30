package wellsome.model;

import java.util.ArrayList;

public class CartDAO {
	
	private ArrayList<ProductDTO> cartList;
	
	public CartDAO() {
		cartList = new ArrayList<ProductDTO>();
	}
	
	// 장바구니에 상품 추가
	public void addProduct(ProductDAO pDao, String pNum, String pQty, String pSpec) {
		
		// 상품 수량
		int addQty = Integer.parseInt(pQty);
		System.out.println("addQty : " + addQty);
		
		for(ProductDTO pDto : cartList) {
			if(pNum.equals(String.valueOf(pDto.getpNum()))) {
				pDto.setpQty(pDto.getpQty()+addQty);
				System.out.println("DAO dto : " + pDto);
				return;
			}
		}
		
		ProductDTO pDto = pDao.getProduct(pNum, pSpec);
		System.out.println("상품 가져오기 완료!!");
		
		if(pDto != null) {
			pDto.setpQty(addQty);
			cartList.add(pDto);
			System.out.println("DAO cartList : " + cartList);
		}
	}
	
	// 장바구니 상품 가져오기
	public ArrayList<ProductDTO> getCartList(){
		System.out.println("DAO getCartList : " + cartList.size());
		System.out.println("DAO getCartList : " + cartList);
		return cartList;
	}
	
	// 장바구니 삭제
	public void deleteProduct(String pNum) {
		for(ProductDTO dto : cartList) {
			if(pNum.equals(String.valueOf(dto.getpNum()))) {
				cartList.remove(dto);
				break;
			}
		}
	}
	
	// 장바구니 수정
	public void updateProduct(String pNum, String pQty) {
		int qty = Integer.parseInt(pQty);
		
		for(ProductDTO dto : cartList) {
			if(pNum.equals(String.valueOf(dto.getpNum()))) {
				if(qty<=0) {
					cartList.remove(dto);
					break;
				}else {
					dto.setpQty(qty);
					break;
				}
			}
		}
	}
	
	

}
