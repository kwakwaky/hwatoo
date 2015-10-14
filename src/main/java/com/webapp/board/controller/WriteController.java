package com.webapp.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.board.command.WriteCommand;
import com.webapp.board.dao.BoardDao;

@Controller
@RequestMapping("/board/write")
public class WriteController {
	
	@Autowired
	BoardDao dao;

	@RequestMapping(method=RequestMethod.GET)
	public String writeForm(@ModelAttribute("write") WriteCommand command) {
		return "board/write";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String writeItem(@ModelAttribute("write") WriteCommand command) {
		dao.writeItem(command.getBoardModel());
		return "redirect:/board";
	}
	
}
