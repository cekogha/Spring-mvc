package fr.cekogha.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.cekogha.model.User;
import fr.cekogha.service.UserService;

@Controller
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginForm(HttpSession session, Model model) {
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String username, @RequestParam String password,
			HttpSession session, Model model) {
		log.warn("Connexion attempt from : ["+ username+"] with ["+password+"]");
		User user = userService.loginUser(username, password);
		
		if(user != null) {
			log.warn(user.toString());
			session.setAttribute("loggedInUser", user);
		}else {
			log.warn("Connexion unauthorized for : ["+ username+"] with ["+password+"]");
			model.addAttribute("loginError", "Username or Password incorrect");
		}
		return "redirect:/";
	}


}
