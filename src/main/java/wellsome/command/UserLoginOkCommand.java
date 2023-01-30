package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wellsome.model.CartDAO;
import wellsome.model.UserDAO;
import wellsome.model.UserDTO;

public class UserLoginOkCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDTO dto = new UserDTO(id, pw);
		UserDAO dao = new UserDAO();
		
		String userName = dao.userLogin(dto);
		System.out.println("~~~~~~userName : " + userName);
		
		String viewPage = null;
		if(userName != null) { 
			session.setAttribute("id", id);
			session.setAttribute("userName", userName);
			
			session.setAttribute("isLogin", "yes");
			session.setAttribute("memberInfo", "user");
			
			CartDAO shopCart = new CartDAO();
	  		session.setAttribute("shopCart", shopCart);
			
			viewPage = "/customer/user_main.jsp";
		}else { 
			request.setAttribute("msg", "아이디 또는 비밀번호가 올바르지 않습니다!!");
			viewPage = "userLogin.do";
			
		}
		
		return viewPage;
	}
}
