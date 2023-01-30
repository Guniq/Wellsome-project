package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.BoardDAO;
import wellsome.model.BoardDTO;

public class UserBoardInfoCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getBoard(bNum);
		System.out.println("~~~~~~dto : " + dto);
		
		request.setAttribute("dto", dto);
		
		return "/customer/user_boardInfo.jsp";
	}
}
