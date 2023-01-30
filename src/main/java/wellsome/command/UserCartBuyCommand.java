package wellsome.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wellsome.model.CartDAO;
import wellsome.model.ProductDTO;
import wellsome.model.UserDAO;
import wellsome.model.UserDTO;

public class UserCartBuyCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CartDAO shopCart = (CartDAO)session.getAttribute("shopCart");
		ArrayList<ProductDTO> pDtos = shopCart.getCartList();
		
		// 구매할 사람(로그인한 유저)의 정보를 가져오기
		String id = (String)session.getAttribute("id");
		UserDAO uDao = new UserDAO();		
		UserDTO uDto = uDao.getUser(id);
		
		request.setAttribute("pDtos", pDtos);
		request.setAttribute("uDto", uDto);
		
		return "/customer/cart_buy.jsp";
	}
}
