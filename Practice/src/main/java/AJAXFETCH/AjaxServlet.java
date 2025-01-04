package AJAXFETCH;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajaxServlet.do")
public class AjaxServlet extends HttpServlet{
//	as
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//JSON 응답 생성
		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().write("{\"message\": \"AJAX 요청 성공!\"}");
	}
}
