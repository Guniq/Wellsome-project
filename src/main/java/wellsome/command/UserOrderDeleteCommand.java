package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wellsome.model.CartDAO;


public class UserOrderDeleteCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CartDAO shopCart = (CartDAO)session.getAttribute("shopCart");
		
		String pNums = request.getParameter("delProdNums");

		String[] pNumArr = pNums.split("/");
		
		if(pNumArr !=null && pNumArr.length > 0){
			for(int i=0; i<pNumArr.length; i++){
				// 장바구니에 있는 상품을 삭제
				shopCart.deleteProduct(pNumArr[i]);
			}
		}
		
		return "cartBuy.do";
	}
}
