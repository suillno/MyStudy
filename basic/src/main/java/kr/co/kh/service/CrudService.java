package kr.co.kh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
	
	// insert, select, update, delete
	void insert(HashMap<String, Object> requstMap);
	
	List<T> selectList(HashMap<String, Object> requstMap);
	
	Optional<T> selectOne(HashMap<String, Object> requstMap);
	
	void update(HashMap<String, Object> requstMap);
	
	void delete(HashMap<String, Object> requstMap);
}
