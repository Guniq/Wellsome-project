package wellsome.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.BoardDAO;
import wellsome.model.BoardDTO;

public class BoardUpdateCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getBoard(bNum);
		request.setAttribute("dto", dto);
		
		return "/admin/board_update.jsp";
	}
}
