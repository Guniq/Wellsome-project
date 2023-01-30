package wellsome.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.CategoryDAO;
import wellsome.model.CategoryDTO;
import wellsome.model.ProductDAO;
import wellsome.model.ProductDTO;
import wellsome.util.ProdSpec;

public class UserProductListCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> dtos = dao.productList();
		request.setAttribute("dtos", dtos);
		
		CategoryDAO cDao = new CategoryDAO();
		List<CategoryDTO> list = cDao.categoryList();
		request.setAttribute("list", list);
		
		ProdSpec[] pdSpecs = ProdSpec.values();
		request.setAttribute("pdSpecs", pdSpecs);
		
		return "/customer/userProduct_list.jsp";
	}
}
