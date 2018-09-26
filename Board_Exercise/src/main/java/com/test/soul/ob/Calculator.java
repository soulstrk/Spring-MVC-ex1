package com.test.soul.ob;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.soul.dao.BoardDao;

@Component
public class Calculator {
	@Autowired
	private BoardDao dao;
	
	// 페이징 처리 계산 메소드
	public Map calPageRow(int pageNum, Map map){
		int startRow = pageNum * 10 - 9;
		int endRow = startRow + 9;
		int startPage = ((pageNum-1)/10+1) * 10 - 9;
		int endPage = startPage + 9;
		int maxCount = dao.getCount(map); //�� �Խñ� ��
		int maxPage = (maxCount-1)/10 +1; //�� ������
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
