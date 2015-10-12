package com.webapp.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@ModelAttribute("pageInfo")
	public Pagination getPageInfo() {
		page = new Pagination();
		page.setTotalItem(dao.totalCount());
		
		return page;
	}

	@RequestMapping(value="/{pageNo:[0-9]*}", method=RequestMethod.GET)
	public String boardPage(HttpServletRequest request, Model model, @PathVariable String pageNo) {
		log.info("boardPage() start...");
		log.info("총 게시물 수 = " + dao.totalCount());
		log.info("모든 게시글 = " + dao.selectAll().size());
		log.info("StartNum = " + page.getStartNum());
		log.info("EndNum = " + page.getEndNum());
		
		
		String num = request.getParameter("num");
		if (num != null && !num.equals("")) {
			log.info("num = " + num);
			BoardModel content = dao.readContentByNum(Integer.parseInt(num));
			model.addAttribute("content", content);
			return "board/read";
		}
		
		page.setPageNo(Integer.parseInt(pageNo));
		
		List<BoardModel> board = dao.selectCurrentPage(page.getStartNum(), page.getEndNum());
		
		model.addAttribute("board", board);
		return "board/board";
	}
	
	
}
