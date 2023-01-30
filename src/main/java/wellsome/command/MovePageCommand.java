package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovePageCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// FrontController에서 바인딩한 cmd를 가져오기
		String cmd = (String)request.getAttribute("cmd");
		System.out.println("cmd : " + cmd);
		
		String viewPage = null;
		if(cmd.equals("/adminLogin.do")) {
			viewPage = "/admin/admin_login.jsp";
			
		}else if(cmd.equals("/categoryInput.do")) {
			viewPage = "/admin/category_input.jsp";
			
		}else if(cmd.equals("/productInput.do")) {
			viewPage = "/admin/product_input.jsp";
			
		}else if(cmd.equals("/boardInput.do")) {
			viewPage = "/admin/board_input.jsp";
			
		}else if(cmd.equals("/userJoin.do")) {
			viewPage = "/customer/user_join.jsp";
			
		}else if(cmd.equals("/userLogin.do")) {
			viewPage = "/customer/user_login.jsp";
			
		}
			
			
		
		return viewPage;
	}
}
