package wellsome.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.BoardDAO;
import wellsome.model.BoardDTO;

public class UserBoardCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> dtos = dao.boardList(); 
		System.out.println("~~~~~~~~~dtos : " + dtos);
		
		request.setAttribute("dtos", dtos);
		
		return "/customer/user_board.jsp";
	}
}
