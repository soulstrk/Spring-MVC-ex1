package com.test.soul.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.soul.dao.Board2Dao;
import com.test.soul.vo.Board2Vo;

@Service
public class Board2Service {
	@Autowired
	private Board2Dao dao;
	
	public int insert(Board2Vo vo) {
		return dao.insert(vo);
	}
	
	public int getCount(HashMap<String, Object> map) {
		return dao.getCount(map);
	}
	
	public List<Board2Vo> list(HashMap<String, Object> map){
		return dao.list(map);
	}
	
	public int update(HashMap<String, Object> map) {
		return dao.update(map);
	}
	
	public Board2Vo getOne(int num) {
		return dao.getOne(num);
	}
	
	public int delete(int num) {
		return dao.delete(num);
	}
	
	public Board2Vo prev(int num) {
		return dao.prev(num);
	}
	
	public Board2Vo next(int num) {
		return dao.next(num);
	}
	
	public int addHit(int num) {
		return dao.addHit(num);
	}
}
