package com.test.soul.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.soul.vo.GuestBoardCommVo;

@Repository
public class BoardCommDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "com.test.soul.Mapper.BoardCommMapper.";
	
	public int insert(GuestBoardCommVo vo) {
		return session.insert(NAMESPACE+"insert", vo);
	}
	
	public int delete(int cnum) {
		return session.delete(NAMESPACE+"delete", cnum);
	}
	
	public List<GuestBoardCommVo> getList(int mnum){
		return session.selectList(NAMESPACE+"getCommList", mnum);
	}
}
