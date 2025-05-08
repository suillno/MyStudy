package kr.co.kh.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.kh.dao.BoardDAO;
import kr.co.kh.serviceimpl.BoardServiceImpl;
import kr.co.kh.vo.BoardVO;

import java.io.IOException;
import java.util.HashMap;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// url 호출시 생성자 자동생성을 위한 선언
	private BoardServiceImpl boardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        boardService = new BoardServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트의 GET 요청을 처리하는 메서드 (게시판 목록 조회)

        /**
         * 1. 클라이언트 요청 처리 및 데이터 준비
         */
        // 쿼리 파라미터 등을 저장할 Map 객체 생성 (현재는 빈 Map)
        HashMap<String, Object> requstMap = new HashMap<String, Object>();
        System.out.println(requstMap.toString());  // 요청 파라미터 출력 (디버깅용)

        /**
         * 2. 비즈니스 로직 처리
         */
        // boardService의 selectList() 메서드 호출 → 게시판 글 목록을 가져옴
        // 가져온 리스트를 request 객체에 "list" 속성으로 저장 (JSP에서 사용 가능)
        request.setAttribute("list", boardService.selectList(requstMap));

        /**
         * 3. 뷰 페이지로 데이터 전달 및 포워딩
         */
        // JSP 뷰 페이지로 요청 전달 (forward 방식 → URL 변경 X, request 유지됨)
        RequestDispatcher rd = request.getRequestDispatcher("/board/list.jsp");
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
