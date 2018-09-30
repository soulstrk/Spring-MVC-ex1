package com.test.soul.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.soul.vo.Board2Vo;

@Repository
public class Board2Dao {
	@Autowired
	private SqlSession session;
	private final static String NAMESPACE = "com.test.soul.Mapper.Board2Mapper.";
	
	public int insert(Board2Vo vo) {
		return session.insert(NAMESPACE+"insert",vo);
	}
	
	public int getCount(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+"getCount", map);
	}
	
	public List<Board2Vo> list(HashMap<String, Object> map){
		List<Board2Vo> list = session.selectList(NAMESPACE+"list", map);
		return session.selectList(NAMESPACE+"list", map);
	}
	
	public Board2Vo getOne(int num) {
		return session.selectOne(NAMESPACE+"getOne", num);
	}
	
	public int update(HashMap<String, Object> map) {
		return session.update(NAMESPACE+"update", map);
	}
	
	public int delete(int num) {
		return session.delete(NAMESPACE+"delete", num);
	}
	
	public int addHit(int num) {
		return session.update(NAMESPACE+"addHit", num);
	}
	
	public Board2Vo prev(int num) {
		return session.selectOne(NAMESPACE+"prev", num);
	}
	
	public Board2Vo next(int num) {
		return session.selectOne(NAMESPACE+"next", num);
	}
	
	
}
