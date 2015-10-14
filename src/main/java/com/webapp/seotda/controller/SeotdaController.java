package com.webapp.seotda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
@RequestMapping("/seotda")
public class SeotdaController {
	
	static Log log = LogFactory.getLog(SeotdaController.class);
	
	Gson gson = new Gson();

	@RequestMapping(method=RequestMethod.GET)
	public String main() {
		log.info("main() start...");
		return "seotda/main";
	}
	
	@RequestMapping("/counting")
	public void counting(HttpServletResponse response) throws IOException {
		log.info("counting() start...");
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		
		Map<Integer, String> map = new HashMap<>();
		// 1월
		map.put(1, "1g");
		map.put(2, "1d");
		// 2월
		map.put(3, "2y");
		map.put(4, "2d");
		// 3월
		map.put(5, "3g");
		map.put(6, "3d");
		// 4월
		map.put(7, "4y");
		map.put(8, "4d");
		// 5월
		map.put(9, "5y");
		map.put(10, "5d");
		// 6월
		map.put(11, "6y");
		map.put(12, "6d");
		// 7월
		map.put(13, "7y");
		map.put(14, "7d");
		// 8월
		map.put(15, "8g");
		map.put(16, "8y");
		// 9월
		map.put(17, "9y");
		map.put(18, "9d");
		// 10월
		map.put(19, "10y");
		map.put(20, "10d");
		
		Random ran = new Random();
		int rn = ran.nextInt(20) + 1;
		map.get(rn);
		
		writer.println(gson.toJson(map.get(rn)));
		writer.close();
		
	}
	
	
}
