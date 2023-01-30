package wellsome.frontController;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wellsome.command.WellsomeCommand;


//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private HashMap<String, WellsomeCommand> commandMap = new HashMap<String, WellsomeCommand>();
	
	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		System.out.println("configFile : " + configFile);
		
		String configPath = getServletContext().getRealPath(configFile);
		System.out.println("configPath : " + configPath);
		
		Properties prop = new Properties();
		System.out.println("prop : " + prop);
		
		try {
			FileReader fis = new FileReader(configPath);
			System.out.println("fis : " + fis);
			prop.load(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		Iterator keyIter = prop.keySet().iterator();
		System.out.println("keyIter : " + keyIter);
		
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String cmdValue = prop.getProperty(command);
			
			try {
				Class<?> cmdClass = Class.forName(cmdValue);
				WellsomeCommand cmdInstance = (WellsomeCommand)cmdClass.getDeclaredConstructor().newInstance();
				commandMap.put(command, cmdInstance);
				
				WellsomeCommand cmdInstance2 = commandMap.get(command);
				System.out.println("cmdInstance2 : " + cmdInstance2);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String cmd = uri.substring(ctx.length());
		
		System.out.println("cmd : " + cmd);
		
		request.setAttribute("cmd", cmd);
		
		WellsomeCommand cmdInstance = commandMap.get(cmd);
		
		String viewPage = null;
		viewPage = cmdInstance.execute(request, response);
		
		if(viewPage != null) {
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
		}
	}

}
