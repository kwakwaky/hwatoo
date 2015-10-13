package com.webapp.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.board.command.WriteCommand;
import com.webapp.board.dao.BoardDao;

@Controller
@RequestMapping("/board/update")
public class UpdateController {
	
	@Autowired
	BoardDao dao;

	@RequestMapping(method=RequestMethod.GET)
	public String updateForm(@ModelAttribute("write") WriteCommand command) {
		
		
		return "board/update";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String updateItem(@ModelAttribute("write") WriteCommand command) {
		return "redirect:/";
	}
	
}
