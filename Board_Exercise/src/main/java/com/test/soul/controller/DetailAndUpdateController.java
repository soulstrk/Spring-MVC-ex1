package com.test.soul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.soul.service.BoardService;
import com.test.soul.vo.GuestBoardCommVo;
import com.test.soul.vo.GuestBoardVo;

@Controller
public class DetailAndUpdateController {
	@Autowired
	private BoardService service;
	
	@ModelAttribute("vo")
	public GuestBoardVo vo(int num) {
		return service.detail(num);
	}
	
	//글 상세 보기
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(int num, int spageNum) {
		ModelAndView mv = new ModelAndView("detail");
		List<GuestBoardCommVo> list = service.commGetList(num);
		mv.addObject("list", list);
		mv.addObject("pageNum", spageNum);
		return mv;
	}
	
	@RequestMapping("update")
	public ModelAndView update(int num, int spageNum) {
		ModelAndView mv = new ModelAndView("update");
		mv.addObject("pageNum", spageNum);
		return mv;
	}
}
