package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import wellsome.model.ProductDAO;
import wellsome.model.ProductDTO;

public class ProductInputOkCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
//		HashMap<String,Object> map = new HashMap<>();
		
		String realPath = request.getServletContext().getRealPath("/uploadedFile");
		System.out.println("realPath : "+realPath);
		
		int maxSize = 1024 * 1024 * 10;
		
		String viewPage = null;
		try {
			MultipartRequest mr = new MultipartRequest(request, realPath, maxSize,
					"utf-8", new DefaultFileRenamePolicy());
			System.out.println("mr : " + mr);
			
			String pName = mr.getParameter("pName");
			System.out.println("~~~~~~~~~~~~~~~pName : " + pName);
			String pCategory_fk = mr.getParameter("pCategory_fk");
			String pImage = mr.getFilesystemName("pImage");
			int price = Integer.parseInt(mr.getParameter("price"));
			System.out.println("price : " + price);
			int pQty = Integer.parseInt(mr.getParameter("pQty"));
			String pSpec = mr.getParameter("pSpec");
			String pContent = mr.getParameter("pContent");
			int pPoint = Integer.parseInt(mr.getParameter("pPoint"));
			
			ProductDTO dto = new ProductDTO(pName, pCategory_fk, pImage, price, pQty, pSpec, pContent, pPoint);
			System.out.println("ProductInputOkCommand.execute() dto : " + dto);
//			map.put("dto", dto);
//			map.put("mr", mr);
//			System.out.println("map : "+map);
			
			ProductDAO dao = new ProductDAO();
//			int n = dao.productInput(map);
			int n = dao.productInput(dto);
			System.out.println("n : " + n );
			
			if(n>0){
				request.setAttribute("msg", "상품등록 완료!!");
				viewPage ="productList.do";
			}else{
				request.setAttribute("msg", "상품등록 실패!!");
				viewPage ="/admin/product_input.jsp";
			}
		}catch (Exception e){
			request.setAttribute("msg", "파일 업로드 실패!!");
			viewPage ="/admin/product_input.jsp";
			e.printStackTrace();
		}
		
		return viewPage;
	}
}
