package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet(description = "로그인처리", urlPatterns = { "/loginAction" })
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	로그인 동작처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		로그인 값 읽기
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		System.out.println(userId);
		System.out.println(password);
		
//		로그인동작시 표기화면 그리기
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<!doctype html><html><head><title>로그인처리</title></head><body>");
		out.append("<h2>로그인 완료<h2>");
		out.append("<p>"+userId+"님 반갑습니다. </p>");
		out.append("</body></html>");
		
		
		
//		doGet(request, response);
	}

}
