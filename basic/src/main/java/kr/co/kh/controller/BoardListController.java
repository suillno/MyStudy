package kr.co.kh.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.kh.dao.BoardDAO;
import kr.co.kh.serviceimpl.BoardServiceImpl;
import kr.co.kh.vo.SearchHelper;

import java.io.IOException;
import java.util.HashMap;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceImpl boardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        boardService = new BoardServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("title", "게시물 목록");
		
		SearchHelper searchHelper = new SearchHelper();
		String searchType = request.getParameter("searchType") == null ? "" : request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword") == null ? "" : request.getParameter("searchKeyword");
		Long page = request.getParameter("page") == null ? 0L : Long.parseLong(request.getParameter("page"));
		Long pageSize = request.getParameter("pageSize") == null ? 10L : Long.parseLong(request.getParameter("pageSize"));
		searchHelper.setSearchType(searchType);
		searchHelper.setSearchKeyword(searchKeyword);
		searchHelper.setPage(page);
		searchHelper.setPageSize(pageSize);
		
		request.setAttribute("list", boardService.selectList(searchHelper));
		
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
