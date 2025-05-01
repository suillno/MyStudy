package calculator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Calc
 */
@WebServlet(description = "계산기", urlPatterns = { "/calc" })
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcAction() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		값 읽기 name 을 기준으로 값을 가져온다
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String oper = request.getParameter("oper");
		int n1 = Integer.valueOf(num1);
		int n2 = Integer.valueOf(num2);
		int answer = 0;
		
		switch (oper) {
		case "+": answer = n1 + n2;
			break;
		case "-": answer = n1 - n2;
		break;
		case "/": answer = n1 / n2;
		break;
		case "*": answer = n1 * n2;
		break;
		}
		
		// request에 데이터를 저장 (JSP로 전달)
		request.setAttribute("result", answer);
		
		// 포워딩 : 지금 url 다른 url로 값 보내기
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("calcResult.jsp");
		requestDispatcher.forward(request, response);
		
//		doGet(request, response);
	}

}
