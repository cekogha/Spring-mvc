package fr.cekogha.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

	private static Logger log = LoggerFactory.getLogger(LogoutController.class);
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String verifyLogin(HttpSession session, Model model) {
		
		log.warn(session.getAttribute("loggedInUser") + " is deconnected");
		
		session.removeAttribute("loggedInUser");
		return "redirect:/";
	}
}
