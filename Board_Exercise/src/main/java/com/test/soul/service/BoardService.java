package com.test.soul.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.soul.dao.BoardDao;
import com.test.soul.vo.GuestBoardVo;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	
	public int insert(GuestBoardVo vo) {
		return dao.insert(vo);
	}
	
	public Map getList(int pageNum){
		Map map = new HashMap();
		map = calPageRow(pageNum);
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
	
	
	public Map calPageRow(int pageNum){
		int startRow = pageNum * 10 - 9;
		int endRow = startRow + 9;
		int startPage = ((pageNum-1)/10+1) * 10 - 9;
		int endPage = startPage + 9;
		int maxCount = dao.getCount(); //ÃÑ °Ô½Ã±Û ¼ö
		int maxPage = (maxCount-1)/10 +1; //ÃÑ ÆäÀÌÁö
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("maxPage", maxPage);
		return map;
	}
}
