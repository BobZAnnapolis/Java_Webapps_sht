package com.howtoprogramwithjava.webapp.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VideoController {

	@RequestMapping("/videos")
	public String getVideos (ModelMap model) {
		
		Date date = new Date();
		
		model.put("now", date);
		model.put("myName", "BobZ");
		
		return "showVideos";
	}
}
