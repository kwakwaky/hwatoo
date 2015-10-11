package com.webapp.board.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.board.dao.BoardDao;
import com.webapp.board.model.BoardModel;
import com.webapp.util.Pagination;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	static Log log = LogFactory.getLog(BoardController.class);
	
	@Autowired
	BoardDao dao;
	
	Pagination page;
	
//	@ModelAttribute("pageInfo")
//	public Map<String, Object> getPageInfo() {
//		Pagination page = new Pagination();
//		page.setTotalItem(dao.totalCount());
//		
//		Map<String, Object> pageInfo = new HashMap<>();
//		pageInfo.put("pageNo", page.getPageNo());
//		pageInfo.put("totalItem", page.getTotalItem());
//		pageInfo.put("totalPage", page.getTotalPage());
//		pageInfo.put("startNum", page.getStartNum());
//		pageInfo.put("endNum", page.getEndNum());
//		pageInfo.put("startPage", page.getStartPage());
//		pageInfo.put("endPage", page.getEndPage());
//		pageInfo.put("isFirstGroup", page.isFirstGroup());
//		pageInfo.put("isLastGroup", page.isLastGroup());
//		
//		return pageInfo;
//	}
	
	@ModelAttribute("pageInfo")
	public Pagination getPageInfo() {
		page = new Pagination();
		page.setTotalItem(dao.totalCount());
		
		return page;
	}

	@RequestMapping(value="/{pageNo:[0-9]*}", method=RequestMethod.GET)
	public String boardPage(Model model, @PathVariable String pageNo) {
		log.info("boardPage() start...");
		log.info("총 게시물 수 = " + dao.totalCount());
		log.info("모든 게시글 = " + dao.selectAll().size());
		
		log.info("StartNum = " + page.getStartNum());
		log.info("EndNum = " + page.getEndNum());
		
		page.setPageNo(Integer.parseInt(pageNo));
		
		List<BoardModel> boardList = dao.selectCurrentPage(page.getStartNum(), page.getEndNum());
		model.addAttribute("board", boardList);
		
		
		
		return "board/board";
	}
}
