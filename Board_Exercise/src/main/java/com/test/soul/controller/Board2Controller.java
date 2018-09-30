package com.test.soul.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.soul.ob.PageUtil;
import com.test.soul.service.Board2Service;
import com.test.soul.vo.Board2Vo;

@Controller
public class Board2Controller {
	@Autowired
	private Board2Service service;
	
	@RequestMapping("/boardlist2")
	public ModelAndView list(@RequestParam(value="pageNum", defaultValue="1")int pageNum,
			String field, String keyword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("field",field);
		map.put("keyword", keyword);
		
		int totalRowCount = service.getCount(map);
		PageUtil pu = new PageUtil(pageNum, 10, 10, totalRowCount);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		List<Board2Vo> list = service.list(map);
		
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("list",list);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		return mv;
	}
	@RequestMapping("/detail2")
	public ModelAndView detail(int num) {
		ModelAndView mv = new ModelAndView("detail2");
		Board2Vo vo = new Board2Vo();
		vo = service.getOne(num);
		mv.addObject("vo",vo);
		return mv;
	}
	
	@RequestMapping(value="/update2", method=RequestMethod.POST)
	public String update(String writer, String title, String content, String num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(num);
		map.put("writer", writer);
		map.put("title", title);
		map.put("content", content);
		map.put("num", num);
		int n = service.update(map);
		System.out.println(n);
		return "redirect:/boardlist2";
	}
	@RequestMapping("/delete2")
	public String delete(int num) {
		int n = service.delete(num);
		return "redirect:/boardlist2";
	}
	
	@RequestMapping("/detail3")
	public String detail3(int num, Model model) {
		Board2Vo vo = service.getOne(num);
		Board2Vo prev = service.prev(num);
		Board2Vo next = service.next(num);
		
		String content = vo.getContent();
		//텍스트에리어는 줄바꿈을 \n으로 표현하고 div는 <br>로 표현함
		//div에 보이기 위해서  <br>로 변환하기
		content = content.replaceAll("\n", "<br>");
		vo.setContent(content);
		
		service.addHit(num);
		
		model.addAttribute("vo", vo);
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		return "detail3";
	}
}
