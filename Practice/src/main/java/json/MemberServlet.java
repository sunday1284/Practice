package json;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.json.JSONObject;
import org.json.JSONTokener;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // member.json 파일을 읽어들임
        InputStream inputStream = getServletContext().getResourceAsStream("/json/member.json");
        if (inputStream == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // JSON 데이터를 파싱
        JSONTokener tokener = new JSONTokener(inputStream);
        JSONObject jsonObject = new JSONObject(tokener);

        // JSON 데이터를 클라이언트에 반환
        PrintWriter out = response.getWriter();
        out.print(jsonObject.toString());
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
