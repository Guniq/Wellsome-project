package wellsome.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import wellsome.model.BoardDAO;
import wellsome.model.BoardDTO;
import wellsome.model.CategoryDAO;
import wellsome.model.CategoryDTO;
import wellsome.model.ProductDAO;
import wellsome.model.ProductDTO;

public class BoardUpdateOkCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardDAO dao = new BoardDAO();	
		
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		String bName = request.getParameter("bName");		
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BoardDTO dto = new BoardDTO(bNum, bTitle, bName, bContent);
		System.out.println("~~~~~~~~~~dto : " + dto);
		
		int n = dao.boardUpdate(dto);
		
		String viewPage = null;		
		if(n > 0){
			request.setAttribute("msg", "공지사항이 수정되었습니다!!!");
			viewPage = "boardList.do";
		}else{
			request.setAttribute("msg", "공지사항 수정 실패!!");
			viewPage = "boardList.do";
		}
	
	return viewPage;
	}
}
