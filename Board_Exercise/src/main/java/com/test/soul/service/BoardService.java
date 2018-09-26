package com.test.soul.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.soul.dao.BoardCommDao;
import com.test.soul.dao.BoardDao;
import com.test.soul.ob.Calculator;
import com.test.soul.vo.GuestBoardCommVo;
import com.test.soul.vo.GuestBoardVo;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	@Autowired
	private BoardCommDao commDao;
	@Autowired
	private Calculator cal;
	
	public int insert(GuestBoardVo vo) {
		return dao.insert(vo);
	}
	
	public Map getList(int pageNum, String title, String content, String writer, String search){
		Map map = new HashMap();
		map.put("title", title);
		map.put("content", content);
		map.put("writer", writer);
		map.put("search", search);
		map = cal.calPageRow(pageNum, map); // Request�� PageNum���� ����¡ó���� �ʿ��� ����
		List<GuestBoardVo> list = dao.getList(map);
		map.put("list", list);
		return map;
	}
	
	public GuestBoardVo detail(int num) {
		dao.updateHit(num);
		return dao.detail(num);
	}
	
	public int update(GuestBoardVo vo) {
		return dao.update(vo);
	}
	
	public int delete(int num) {
		return dao.delete(num);
	}
	
	public int commInsert(GuestBoardCommVo vo) {
		return commDao.insert(vo);
	}
	
	public int commDelete(int cnum) {
		return commDao.delete(cnum);
	}
	
	public List<GuestBoardCommVo> commGetList(int mnum){
		return commDao.getList(mnum);
	}
	
	
}
