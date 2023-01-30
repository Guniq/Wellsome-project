package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.model.UserDAO;
import wellsome.model.UserDTO;

public class UserJoinOkCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String zipcode = request.getParameter("zipcode");
		String road_addr = request.getParameter("road_addr");
		String detail_addr = request.getParameter("detail_addr");
		
		UserDTO dto = new UserDTO(id, pw, name, email, tel, zipcode, road_addr, detail_addr);
		UserDAO dao = new UserDAO();
		
		int n = dao.userJoin(dto);
		
		String viewPage = null;
		if(n > 0) {
			request.setAttribute("msg", "회원가입 축하드립니다!!");
			viewPage = "userLogin.do";
			
		}else {
			request.setAttribute("msg", "회원가입에 실패하셨습니다..");
			viewPage = "userJoin.do";
			
		}
		return viewPage;
	}
}
