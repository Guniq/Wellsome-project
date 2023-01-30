package wellsome.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wellsome.model.CartDAO;
import wellsome.model.ProductDTO;


public class UserCartListCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CartDAO shopCart=(CartDAO)session.getAttribute("shopCart");
		
		ArrayList<ProductDTO> pDtos = shopCart.getCartList();
		request.setAttribute("pDtos", pDtos);
		
		return "/customer/cart_list.jsp";
	}
}
