package wellsome.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.ProductDAO;
import wellsome.model.ProductDTO;

public class ProductListCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> dtos = dao.productList();
		System.out.println("dtos : " + dtos);
		
		request.setAttribute("dtos", dtos);
		
		return "/admin/product_list.jsp";
	}
}
