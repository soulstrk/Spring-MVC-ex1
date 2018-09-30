package com.test.soul.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.soul.service.BoardService;
import com.test.soul.vo.GuestBoardVo;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	// 占쏙옙占쏙옙  --> 占쌉쏙옙占쏙옙
	@RequestMapping("/board")
	public String toBoardList() {
		return "boardlist";
	}
	
	// 占쌜억옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占싱듸옙
	@RequestMapping("/boardInsert")
	public String toBoardInsert() {
		return "boardInsert";
	}
	
	// 占쏙옙 占쏙옙占� 占쏙옙占쏙옙
	@RequestMapping(value="/boardInsert", method=RequestMethod.POST)
	public String boardInsert(GuestBoardVo vo, RedirectAttributes ra) {
		int n = service.insert(vo);
		if(n>0) {
		ra.addFlashAttribute("msg", "占쌜듸옙究占쏙옙占�!");
		}
		return "redirect:/boardlist";
	}
	
	/*//占쏙옙 占쏙옙 占쏙옙占쏙옙
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(int num, String update) {
		ModelAndView mv = null;
		if(update != null) {
			mv = new ModelAndView("update");
		}else {
			mv = new ModelAndView("detail");
		}
		GuestBoardVo vo = service.detail(num); 
		mv.addObject("vo",vo);
		return mv;
	}*/
	
	// 占쏙옙 占쏙옙占쏙옙
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(GuestBoardVo vo, RedirectAttributes ra) {
		ra.addFlashAttribute("upMsg", "success");
		System.out.println(vo);
		int n = service.update(vo);
		return "redirect:/boardlist";
	}
	
	// 占쏙옙占쏙옙징처占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쌉쏙옙占쏙옙 占쏙옙占쏙옙트 호占쏙옙
	@RequestMapping(value="/boardlist", method=RequestMethod.GET)
	public ModelAndView boardList(String spageNum, String title, String writer, String content, String search) {
		int pageNum = 0;
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}else {
			pageNum = 1;
		}
		
		Map map = service.getList(pageNum, title, content, writer, search); //占쏙옙占쏙옙 호占쏙옙
		
		//ModelAndView占쏙옙 占십울옙占쏙옙 占쏙옙占쏙옙 占쏙옙티占� 占쏙옙占쏙옙占쏙옙
		ModelAndView mv = new ModelAndView("boardlist");
		mv.addObject("startPage", map.get("startPage"));
		mv.addObject("endPage", map.get("endPage"));
		mv.addObject("startRow", map.get("startRow"));
		mv.addObject("endRow", map.get("endRow"));
		mv.addObject("maxPage", map.get("maxPage"));
		mv.addObject("nowPageNum", pageNum);
		mv.addObject("title", title);
		mv.addObject("content", content);
		mv.addObject("writer", writer);
		mv.addObject("search", search);
		mv.addObject("list", map.get("list"));
		return mv;
	}
	
	// 占쏙옙 占쏙옙占쏙옙
	@RequestMapping("delete")
	public String delete(int num) {
		int n = service.delete(num);
		return "redirect:/boardlist";
	}
}
