package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wellsome.model.BoardDAO;
import wellsome.model.CategoryDAO;

public class BoardDeleteCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		
		BoardDAO dao = new BoardDAO();
		int n = dao.boardDelete(bNum);
		
		
		if(n > 0) {
			request.setAttribute("msg", "공지사항 삭제 성공!!");
			
		}else {
			request.setAttribute("msg", "공지사항 삭제 실패!!");
			
		}
		
		return "boardList.do";
	}
}
