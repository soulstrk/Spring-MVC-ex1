package com.test.soul.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	// 메인  --> 게시판
	@RequestMapping("/board")
	public String toBoardList() {
		return "boardlist";
	}
	
	// 글쓰기 페이지로 이동
	@RequestMapping("/boardInsert")
	public String toBoardInsert() {
		return "boardInsert";
	}
	
	// 글 등록 수행
	@RequestMapping(value="/boardInsert", method=RequestMethod.POST)
	public String boardInsert(GuestBoardVo vo, RedirectAttributes ra) {
		int n = service.insert(vo);
		if(n>0) {
		ra.addFlashAttribute("msg", "글등록성공!");
		}
		return "redirect:/boardlist";
	}
	
	/*//글 상세 보기
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
	
	// 글 수정
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(GuestBoardVo vo, RedirectAttributes ra) {
		ra.addFlashAttribute("upMsg", "success");
		System.out.println(vo);
		int n = service.update(vo);
		return "redirect:/boardlist";
	}
	
	// 페이징처리를 포함한 게시판 리스트 호출
	@RequestMapping(value="/boardlist", method=RequestMethod.GET)
	public ModelAndView boardList(String spageNum) {
		int pageNum = 0;
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}else {
			pageNum = 1;
		}
		
		Map map = service.getList(pageNum); //서비스 호출
		
		//ModelAndView에 필요한 정보 담아서 보내기
		ModelAndView mv = new ModelAndView("boardlist");
		mv.addObject("startPage", map.get("startPage"));
		mv.addObject("endPage", map.get("endPage"));
		mv.addObject("startRow", map.get("startRow"));
		mv.addObject("endRow", map.get("endRow"));
		mv.addObject("maxPage", map.get("maxPage"));
		mv.addObject("list", map.get("list"));
		return mv;
	}
	
	// 글 삭제
	@RequestMapping("delete")
	public String delete(int num) {
		int n = service.delete(num);
		return "redirect:/boardlist";
	}
}
