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
 * Servlet implementation class BoardWriteController
 */
@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardServiceImpl boardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteController() {
        super();
        boardService = new BoardServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("title", "게시물 작성");
		
		String id = request.getParameter("id");
		if (id != null) {
			Long boardNo = Long.parseLong(request.getParameter("id"));
			HashMap<String, Object> requestMap = new HashMap<String, Object>();
			requestMap.put("boardNo", boardNo);
			Optional<BoardVO> result = boardService.selectOne(requestMap);
			request.setAttribute("result", result.get());
		} else {
			BoardVO boardVO = new BoardVO();
			request.setAttribute("result", boardVO);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/write.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// int resultCount = boardService.insert(null);
		// doGet(request, response);
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		System.out.println(boardTitle);
		System.out.println(boardContent);
		String id = request.getParameter("id");
		// vo에 위 파라미터를 담는다. 
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardTitle(boardTitle);
		boardVO.setBoardContent(boardContent);
		boardVO.setBoardWriter("작성자");
		
		int resultCount = 0;
		if (id.equals("")) {
			// 단, 작성자 ID가 없기 때문에 작성자 ID는 임의로 set 메서드를 사용해서 넣는다.
			resultCount = boardService.insert(boardVO);
			System.out.println(resultCount);
		} else {
			boardVO.setBoardNo(Long.parseLong(id));
			resultCount = boardService.update(boardVO);
		}
		
		// 결과 카운트가 있으면 지정된 경로로 이동하고 그렇지 않으면 페이지에 다시 포워딩한다.
		if (resultCount > 0) {
			// 리다이렉트 (지정된 URL로 이동)
			response.sendRedirect("/board/list");
		} else {
			request.setAttribute("title", "게시물 작성");
			RequestDispatcher rd = request.getRequestDispatcher("/board/write.jsp");
			rd.forward(request, response);	
		}
	}

}
