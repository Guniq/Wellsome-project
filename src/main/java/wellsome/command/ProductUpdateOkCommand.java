package wellsome.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import wellsome.model.CategoryDAO;
import wellsome.model.CategoryDTO;
import wellsome.model.ProductDAO;
import wellsome.model.ProductDTO;

public class ProductUpdateOkCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HashMap<String,Object> map = new HashMap<>();
		
		request.setCharacterEncoding("utf-8");
		MultipartRequest mr = null;
		
		String realPath = request.getServletContext().getRealPath("uploadedFile");
		
		ProductDAO dao = new ProductDAO();
		
		String viewPage = null;
		try{
			mr = new MultipartRequest(request, realPath, 1024*1024*10, 
					"utf-8", new DefaultFileRenamePolicy());
			
			int pNum = Integer.parseInt(mr.getParameter("pNum"));
			String pName = mr.getParameter("pName");		
			String pCategory_fk = mr.getParameter("pCategory_fk");
			String pImage = mr.getFilesystemName("pImage");
			System.out.println("pImage : " + pImage);
			int price = Integer.parseInt(mr.getParameter("price"));
			System.out.println("price : " + price);
			int pQty = Integer.parseInt(mr.getParameter("pQty"));
			System.out.println("pQty : " + pQty);
			String pSpec = mr.getParameter("pSpec");
			String pContent = mr.getParameter("pContent");
			int pPoint = Integer.parseInt(mr.getParameter("pPoint"));
			
			ProductDTO dto = new ProductDTO(pNum, pName, pCategory_fk, pImage, price, pQty, pSpec, pContent, pPoint);
			System.out.println("~~~~~~~~~~dto : " + dto);
//			map.put("dto", dto);
//			map.put("mr", mr);
			
			int n = dao.productUpdate(dto);
			System.out.println("~~~~~~~~~~~~~~n : " + n);
			
			if(n > 0){
				request.setAttribute("msg", "상품 정보가 수정되었습니다!!!");
				viewPage = "productList.do";
			}else{
				request.setAttribute("msg", "상품 정보 수정 실패!!");
				viewPage = "productList.do";
			}
		}catch(Exception e){
			request.setAttribute("msg", "파일 업로드 실패!!");
			viewPage = "productList.do";
		}		
		
		return viewPage;
	}
}
