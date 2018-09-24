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
	
	public Map getList(int pageNum, String title, String content, String writer, String search){
		Map map = new HashMap();
		map.put("title", title);
		map.put("content", content);
		map.put("writer", writer);
		map.put("search", search);
		map = calPageRow(pageNum, map); // Request된 PageNum으로 페이징처리에 필요한 연산
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
	
	
	public Map calPageRow(int pageNum, Map map){
		int startRow = pageNum * 10 - 9;
		int endRow = startRow + 9;
		int startPage = ((pageNum-1)/10+1) * 10 - 9;
		int endPage = startPage + 9;
		int maxCount = dao.getCount(map); //총 게시글 수
		int maxPage = (maxCount-1)/10 +1; //총 페이지
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("maxPage", maxPage);
		return map;
	}
}
