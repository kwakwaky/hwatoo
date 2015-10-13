package com.webapp.board.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.board.command.WriteCommand;
import com.webapp.board.dao.BoardDao;
import com.webapp.board.model.BoardModel;

@Controller
@RequestMapping("/board/update")
public class UpdateController {
	
	@Autowired
	BoardDao dao;

	@RequestMapping(method=RequestMethod.GET)
	public String updateForm(HttpServletRequest request, @ModelAttribute("write") WriteCommand command, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("board", dao.readContentByNum(num));
		
		return "board/update";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String updateItem(HttpServletRequest request, @ModelAttribute("write") WriteCommand command) {
		int num = Integer.parseInt(request.getParameter("num"));
		BoardModel boardModel = command.getBoardModel();
		boardModel.setNum(num);
		dao.updateItem(boardModel);
		
		return "redirect:/";
	}
	
}
