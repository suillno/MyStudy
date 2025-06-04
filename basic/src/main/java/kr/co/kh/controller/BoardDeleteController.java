package kr.co.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.kh.serviceimpl.BoardServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet(description = "게시물 삭제", urlPatterns = { "/board/delete" })
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceImpl boardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
        super();
        boardService = new BoardServiceImpl();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] nos = request.getParameterValues("nos");
		for(String no : nos) {
			System.out.println(no);
		}
		if (nos.length > 0) boardService.delete(nos);
		response.sendRedirect("/board/list");
	}

}
