package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.ProductDAO;

public class ProductDeleteCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		
		ProductDAO dao = new ProductDAO();
		int n = dao.productDelete(pNum);
		
		
		if(n > 0) {
			request.setAttribute("msg", "상품 삭제 성공!!");
			
		}else {
			request.setAttribute("msg", "상품 삭제 실패!!");
			
		}
		
		return "productList.do";
	}
}
