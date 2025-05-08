package kr.co.kh.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import kr.co.kh.dao.BoardDAO;
import kr.co.kh.service.CrudService;
import kr.co.kh.vo.BoardVO;

public class BoardServiceImpl implements CrudService<BoardVO> {

	@Override
	public int insert(BoardVO requstMap) {
		// TODO Auto-generated method stub
		BoardDAO boardDAO = new BoardDAO();
		return boardDAO.insertBoard(requstMap);
	}

	@Override
	public List<BoardVO> selectList(HashMap<String, Object> requstMap) {
		// TODO Auto-generated method stub
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> list = boardDAO.selectList(requstMap);
		System.out.println(list.toString());
		return list;
	}

	@Override
	public Optional selectOne(HashMap requstMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(HashMap requstMap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(HashMap requstMap) {
		// TODO Auto-generated method stub
		
	}

}
