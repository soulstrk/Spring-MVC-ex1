package com.test.soul.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.soul.service.BoardService;
import com.test.soul.vo.GuestBoardCommVo;

@Controller
public class BoardCommController {
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/commInsert", method=RequestMethod.POST)
	public void insert(GuestBoardCommVo vo,HttpServletResponse response) {
		int n = service.commInsert(vo);
		List<GuestBoardCommVo> list = null;
		if(n>0) {
			list = service.commGetList(vo.getMnum());
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			response.getWriter().println(mapper.writeValueAsString(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
