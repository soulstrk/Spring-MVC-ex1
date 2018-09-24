package com.test.soul.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.soul.vo.GuestBoardVo;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "com.test.soul.Mapper.BoardMapper.";
	
	public int insert(GuestBoardVo vo) {
		return session.insert(NAMESPACE+"insert", vo);
	}
	
	public List<GuestBoardVo> getList(Map map){
		return session.selectList(NAMESPACE+"getList", map);
	}
	
	public int getCount(Map map) {
		return session.selectOne(NAMESPACE+"getCount", map);
	}
	
	public GuestBoardVo detail(int num) {
		return session.selectOne(NAMESPACE+"detail", num);
	}
	
	public int updateHit(int num) {
		return session.update(NAMESPACE+"updateHit", num);
	}
	
	public int update(GuestBoardVo vo) {
		return session.update(NAMESPACE+"update", vo);
	}
	
	public int delete(int num) {
		return session.delete(NAMESPACE+"delete", num);
	}
}
