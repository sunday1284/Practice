import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/applictionExample.do")
public class ApplicationServlet extends HttpServlet{
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		//애플리케이션 범위 데이터 초기화 
		getServletContext().setAttribute("applicationAtt", "안녕하세요!!");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//애플리케이션 범위 데이터 읽기 -> 형변환을 꼭 해줘야한다.
		
		String newValue = req.getParameter("newValue");
		if(newValue != null && !newValue.trim().isEmpty()) {
			getServletContext().setAttribute("applicationAtt",newValue);	
		}
		
		//jsp로 요청 포워딩
		req.getRequestDispatcher("/01/applicationHandler.jsp").forward(req, resp);
	}
}
