package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.UserDAO;

public class UserIdCheckCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		UserDAO dao = new UserDAO();
		String idChk = dao.userIdChk(id);
		
		response.getWriter().print(idChk);
		
		return null;
	}
}
