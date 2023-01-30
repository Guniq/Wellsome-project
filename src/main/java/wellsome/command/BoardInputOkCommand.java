package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.BoardDAO;
import wellsome.model.BoardDTO;


public class BoardInputOkCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bTitle = request.getParameter("bTitle");
		String bName = request.getParameter("bName");
		String bContent = request.getParameter("bContent");
		
		BoardDTO dto = new BoardDTO(bTitle, bName, bContent);
		System.out.println("~~~~~~~~~dto : " + dto);
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardInput(dto);
		
		String viewPage = null;
		if(cnt > 0) {
			request.setAttribute("msg", "공지사항 등록 성공!");
			viewPage = "boardList.do";
			
		}else {
			request.setAttribute("msg", "공지사항 등록 실패..");
			viewPage = "boardInput.do";
			throw new ServletException("공지사항 등록 실패");
		}
		
		
		return viewPage;
	}
}
