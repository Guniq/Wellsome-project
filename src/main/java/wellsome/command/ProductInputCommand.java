package wellsome.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.CategoryDAO;
import wellsome.model.CategoryDTO;
import wellsome.util.ProdSpec;

public class ProductInputCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CategoryDAO dao = new CategoryDAO();
		List<CategoryDTO> dtos = dao.categoryList();
		request.setAttribute("list", dtos);
		
		ProdSpec[] pdSpecs = ProdSpec.values();
		request.setAttribute("pdSpecs", pdSpecs);
		
		return "/admin/product_input.jsp";
	}
}
