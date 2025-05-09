package kr.co.kh.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.kh.serviceimpl.BoardServiceImpl;
import kr.co.kh.vo.BoardVO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

/**
 * Servlet implementation class BoardViewController
 */
@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceImpl boardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewController() {
        super();
        boardService = new BoardServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("title", "게시물 열람");
		
		Long boardNo = Long.parseLong(request.getParameter("id"));
		HashMap<String, Object> requestMap = new HashMap<String, Object>();
		requestMap.put("boardNo", boardNo);
		Optional<BoardVO> result = boardService.selectOne(requestMap);
		
		request.setAttribute("result", result.get());
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
