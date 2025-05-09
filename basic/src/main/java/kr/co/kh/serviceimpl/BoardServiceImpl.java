package kr.co.kh.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;

import kr.co.kh.dao.BoardDAO;
import kr.co.kh.service.CrudService;
import kr.co.kh.vo.BoardVO;
import kr.co.kh.vo.SearchHelper;

public class BoardServiceImpl implements CrudService<BoardVO> {

	@Override
	public int insert(BoardVO requestMap) {
		// TODO Auto-generated method stub
		BoardDAO boardDAO = new BoardDAO();
		return boardDAO.insertBoard(requestMap);
	}

	@Override
	public List<BoardVO> selectList(SearchHelper searchHelper) {
		// TODO Auto-generated method stub
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> list = boardDAO.selectList(searchHelper);
		System.out.println(list.toString());
		return list;
	}

	@Override
	public Optional<BoardVO> selectOne(HashMap<String, Object> requestMap) {
		// TODO Auto-generated method stub
		BoardDAO boardDAO = new BoardDAO();
		Optional<BoardVO> result = boardDAO.selectOne(requestMap);
		if (result.isPresent()) {
			System.out.println(result.get().toString());
			return result;
		}
		return null;
	}

	@Override
	public int update(BoardVO requestMap) {
		// TODO Auto-generated method stub
		BoardDAO boardDAO = new BoardDAO();
		return boardDAO.update(requestMap);
	}

	@Override
	public int delete(HashMap requestMap) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 게시판의 삭제 번호의 배열로 게시물 삭제
	 * @param nos
	 * @return
	 */
	public int delete(String[] nos) {
		BoardDAO boardDAO = new BoardDAO();
		return boardDAO.delete(nos);
	}

}
