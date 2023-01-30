package wellsome.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wellsome.model.CategoryDAO;
import wellsome.model.CategoryDTO;

public class CategoryListCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CategoryDAO dao = new CategoryDAO();
		List<CategoryDTO> dtos = dao.categoryList(); 
		
		request.setAttribute("list", dtos);
		
		return "/admin/category_list.jsp";
	}
}
