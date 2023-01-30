package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.ProductDAO;
import wellsome.model.ProductDTO;

public class UserProductViewCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		
		ProductDAO dao = new ProductDAO();
		ProductDTO dtos = dao.getProduct(pNum);
		System.out.println("dtos : " + dtos);
		
		request.setAttribute("pDto", dtos);
		
		return "/customer/userProduct_view.jsp";
	}
}
