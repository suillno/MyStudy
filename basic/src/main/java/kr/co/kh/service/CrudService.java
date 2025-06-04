package kr.co.kh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import kr.co.kh.vo.SearchHelper;

public interface CrudService<T> {
	
	int insert(T requestMap);
	
	List<T> selectList(SearchHelper searchHelper);
	
	Optional<T> selectOne(HashMap<String, Object> requestMap);
	
	int update(T requestMap);
	
	int delete(HashMap<String, Object> requestMap);

}
