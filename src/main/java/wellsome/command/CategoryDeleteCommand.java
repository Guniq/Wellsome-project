package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wellsome.model.CategoryDAO;

public class CategoryDeleteCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		CategoryDAO dao = new CategoryDAO();
		int n = dao.categoryDelete(num);
		
		
		if(n > 0) {
			request.setAttribute("msg", "카테고리 삭제 성공!!");
			
		}else {
			request.setAttribute("msg", "카테고리 삭제 실패!!");
			
		}
		
		return "categoryList.do";
	}
}
