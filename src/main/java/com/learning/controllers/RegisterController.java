package com.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learning.dao.UserDao;
import com.learning.entites.User;

@Controller
// @RequestMapping("/userapp")
public class RegisterController {
	@Autowired
	private UserDao userDao;

	@RequestMapping("/")
	public String home() {

		return "index";
	}

	// method to save the user details
	@RequestMapping("/register")
	public ModelAndView save(@ModelAttribute User user) throws Exception {
		ModelAndView mvc = new ModelAndView();
		if (userDao != null && !StringUtils.isEmpty(user)) {
			try {
				userDao.save(user);
				mvc.addObject("user", user);
				mvc.setViewName("registered");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		throw(new Exception("User Not saved"));	
		
		return mvc;
	}
}
