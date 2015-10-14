package com.webapp.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.webapp.board.command.WriteCommand;
import com.webapp.board.dao.BoardDao;
import com.webapp.board.model.BoardModel;

@Controller
@RequestMapping("/board/delete")
public class DeleteController {
	
	@Autowired
	BoardDao dao;
	Gson gson = new Gson();
	
	@RequestMapping(method=RequestMethod.GET)
	public String deleteForm(HttpServletRequest request, @ModelAttribute("write") WriteCommand command) {
		request.setAttribute("num", request.getParameter("num"));
		return "board/delete";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void deleteCheck(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json; charset=utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		BoardModel board = dao.readContentByNum(num);
		
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			
			if (request.getParameter("password").equals(board.getPassword()))
				writer.println(gson.toJson("ok"));
			else
				writer.println(gson.toJson("no"));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(writer != null) writer.close();
		}
		
	}
	
	@RequestMapping("/action")
	public String deleteItem(int num) {
		dao.deleteItem(num);
		
		return "redirect:/board";
	}
	
	
}
