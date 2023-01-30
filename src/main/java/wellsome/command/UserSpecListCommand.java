package wellsome.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.ProductDAO;
import wellsome.model.ProductDTO;
import wellsome.util.ProdSpec;

public class UserSpecListCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pSpec = request.getParameter("pSpec");
		
		ProductDAO pDao = new ProductDAO();
		List<ProductDTO> dtos = pDao.getProductBySpec(pSpec);
		System.out.println("~~~~~~command dtos : " + dtos);
		System.out.println("dtos size : " + dtos.size());
		String specValue = ProdSpec.valueOf(pSpec).getValue();
		
		request.setAttribute("specValue", specValue);
		request.setAttribute("pSpec", pSpec);
		System.out.println("specValue : " + specValue);
		
		ProdSpec[] pdSpecs = ProdSpec.values();
		request.setAttribute("pdSpecs", pdSpecs);
		
		String viewPage = null; 
		if(dtos.size() == 0) {
			request.setAttribute("msg", "상품이 존재하지 않습니다!!!");			
			viewPage = "userProductList.do";
		}else{
			request.setAttribute("dtos", dtos);
			viewPage = "/customer/userSpec_list.jsp";
		}
		System.out.println("viewPage = " + viewPage);
		return viewPage;
	}
}
