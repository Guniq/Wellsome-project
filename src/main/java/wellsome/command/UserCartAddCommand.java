package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wellsome.model.CartDAO;
import wellsome.model.ProductDAO;

public class UserCartAddCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CartDAO shopCart = (CartDAO)session.getAttribute("shopCart");
		System.out.println("~~~~~~~shopCart : " + shopCart);
		
		String pNum = request.getParameter("pNum");
		String pSpec = request.getParameter("pSpec");
		String pCategory_fk = request.getParameter("pCategory_fk");
		String pQty = request.getParameter("pQty");
		
		System.out.println("pSpec ~~~~~??? : "+pSpec);
		System.out.println("pCategory_fk ~~~~~??? : "+pCategory_fk);
		
		ProductDAO pDao = new ProductDAO();
		
		if(pCategory_fk == null || pCategory_fk.trim().length() == 0) {
			shopCart.addProduct(pDao, pNum, pQty, pSpec);
			System.out.println("1111111shopCart : " + shopCart);
			
		}else {
			shopCart.addProduct(pDao, pNum, pQty, pCategory_fk);
			System.out.println("22222222shopCart : " + shopCart);
		}
		
		System.out.println("장바구니 담기 성공!");
		
		
		return "cartList.do";
	}
}
