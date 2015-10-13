package com.webapp.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@ModelAttribute("pageInfo")
	public Pagination getPageInfo() {
		page = new Pagination();
		page.setTotalItem(dao.totalCount());
		
		return page;
	}

	// 게시판 글 가져오기
	@RequestMapping(/*value="{pageNo}",*/ method=RequestMethod.GET)
	public String boardPage(HttpServletRequest request, Model model /*, @PathVariable String pageNo*/) {
		log.info("boardPage() start...");
		
		String num = request.getParameter("num");
		if (num != null && !num.equals("")) {
			return readItem(num, model);
		}
		
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null)
			pageNo = "1";
			
		page.setPageNo(Integer.parseInt(pageNo));
		List<BoardModel> board = dao.selectCurrentPage(page.getStartNum(), page.getEndNum());
		model.addAttribute("board", board);
		
		return "board/board";
	}
	
	// 게시글 읽기 메서드
	public String readItem(String num, Model model) {
		log.info("num = " + num);
		BoardModel item = dao.readContentByNum(Integer.parseInt(num));
		model.addAttribute("item", item);
		
		return "board/read";
	}
	
}
