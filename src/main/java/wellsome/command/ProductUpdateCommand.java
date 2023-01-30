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

public class ProductUpdateCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		
		ProductDAO pDao = new ProductDAO();
		ProductDTO pDto = pDao.getProduct(pNum);
		request.setAttribute("pDto", pDto);
		
		CategoryDAO cDao = new CategoryDAO();
		List<CategoryDTO> list = cDao.categoryList();
		request.setAttribute("list", list);
		
		ProdSpec[] pdSpecs = ProdSpec.values();
		request.setAttribute("pdSpecs", pdSpecs);
		
		
		return "/admin/product_update.jsp";
	}
}
