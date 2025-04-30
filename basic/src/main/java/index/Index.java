package index;
import vo.StudentVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.StudentVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Index
 */
@WebServlet(description = "랜딩페이지", urlPatterns = { "/" })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<StudentVO> stuList = new ArrayList<StudentVO>();
		StudentVO stu1 = new StudentVO();		
		StudentVO stu2 = new StudentVO();		
		stu1.setName("임꺽정");
		stu1.setId(3000);
		stu1.setGrade("A");
		stu2.setName("강감찬");
		stu2.setId(1000);
		stu2.setGrade("A");
		
		stuList.add(stu1);
		stuList.add(stu2);
		
		request.setAttribute("student", stuList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
