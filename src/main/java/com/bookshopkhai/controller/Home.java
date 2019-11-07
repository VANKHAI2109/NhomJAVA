package com.bookshopkhai.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bookshopkhai.dao.userDao;

@Controller
/* @Transactional */
@EnableWebMvc
public class Home {

	private userDao userdao;

	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "index";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {

		return "login";
	}

	@RequestMapping("/register")
	public String register(HttpServletRequest request, HttpServletResponse response) {

		return "register";
	}

	@RequestMapping("/xulylogin")
	public String xulylogin(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "user", defaultValue = "") String name,
			@RequestParam(value = "pass", defaultValue = "") String pass) {

		String username = request.getParameter("user");
		String password = request.getParameter("pass"); // String action = req.getParameter("btn");
		
		boolean checkuser = userdao.login(username, password);
		if (checkuser == true) {
			HttpSession session = request.getSession();
			session.setAttribute("Note", "Chao: " + username);
			return "index";
		} else {
			request.setAttribute("Note", "Dang nhap that bai");
			return "login";
		}
		//model.addAttribute("condition",checkuser);
		

	}

}
