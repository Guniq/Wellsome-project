package wellsome.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.BoardDAO;
import wellsome.model.BoardDTO;

public class BoardListCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> dtos = dao.boardList(); 
		System.out.println("~~~~~~~~~dtos : " + dtos);
		
		request.setAttribute("dtos", dtos);
		
		return "/admin/board_list.jsp";
	}
}
