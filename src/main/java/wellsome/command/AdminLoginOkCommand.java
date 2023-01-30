package wellsome.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wellsome.model.AdminDAO;
import wellsome.model.AdminDTO;

public class AdminLoginOkCommand implements WellsomeCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		AdminDAO dao = new AdminDAO();
		int n = dao.adminCheck(id, pw);
		
		HttpSession session = request.getSession();
		
		if(n == dao.ADMIN_LOGIN_NOT) {
			request.setAttribute("loginErr", "idErr");
			request.setAttribute("msg", "관리자가 아닙니다!!");
			
		}else if(n == dao.ADMIN_LOGIN_PW_FAIL) {
			request.setAttribute("loginErr", "pwErr");
			request.setAttribute("msg", "비밀번호가 일치하지 않습니다!!");
			session.setAttribute("id", id);
			
		}else if(n == dao.ADMIN_LOGIN_SUCCESS){
			AdminDTO dto = dao.getAdminInfo(id);
			
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("isLogin", "yes");
			session.setAttribute("memberInfo", "admin");
			request.setAttribute("msg", " 관리자님 환영합니다!!");
		}
		
		String viewPage = null;
		
		if(request.getAttribute("loginErr") != null) { // 로그인 실패
			viewPage = "adminLogin.do";
			
		}else { // 로그인 성공
			viewPage = "/admin/admin_main.jsp";
		}
		
		return viewPage;
	}
}
