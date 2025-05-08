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

/**
 * Servlet implementation class BoardWriteController
 */
@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // url 호출시 생성자 자동생성을 위한 선언
	private BoardServiceImpl boardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteController() {
        super();
     // url 호출시 생성자 자동생성
        boardService = new BoardServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("title", "게시물 작성");
		RequestDispatcher rd = request.getRequestDispatcher("/board/write.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * write.jsp에서 post로 호출시 (저장버튼) 동작
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// int resultCount = boardService.insert(null);
		// doGet(request, response);
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		// vo에 위 파라미터를 담는다. 단, 작성자 id가 없기때문에 임의로 set 메서드를 활용해 넣는다
		BoardVO board1 = new BoardVO();
		board1.setBoardTitle(boardTitle);
		board1.setBoardContent(boardContent);
		board1.setBoardWrite("강감찬");
		
		// BoardServiceImpl의 insert메서드를 호출
		boardService.insert(board1);
		// 결과 카운트
		int resultCount = boardService.insert(board1);
		// 리다이렉트(지정된 url로 이동) : 입력완료후 list 페이지로 돌아가기
		if (resultCount > 0) {
			response.sendRedirect("/board/list");
		} else {
			request.setAttribute("title", "게시물 작성");
			RequestDispatcher rd = request.getRequestDispatcher("/board/write.jsp");
			rd.forward(request, response);
		}
		
	}

}
