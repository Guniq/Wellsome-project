package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wellsome.model.CategoryDAO;
import wellsome.model.CategoryDTO;

public class CategoryInputOkCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		
		CategoryDTO dto = new CategoryDTO(code, name);
		
		CategoryDAO dao = new CategoryDAO();
		int cnt = dao.categoryInput(dto);
		
		String viewPage = null;
		if(cnt > 0) {
			request.setAttribute("msg", "카테고리 등록 성공!");
			viewPage = "categoryList.do";
			
		}else {
			request.setAttribute("msg", "카테고리 등록 실패..");
			throw new ServletException("카테고리 등록 실패");
		}
		
		
		return viewPage;
	}
}
