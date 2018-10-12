package fr.cekogha.register.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.cekogha.register.service.UserService;

@Controller
public class SignupController {

	private static Logger log = LoggerFactory.getLogger(SignupController.class);

	@Autowired
	private UserService userService;


	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String userInscription(@RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String username, @RequestParam String email,
			@RequestParam String birthday, @RequestParam String password1,
			HttpSession session, Model model) {

		String created = LocalDate.now().toString();
		String role = "GAMER";

		log.warn("Registration attempt from : ["+ username+"]");

		String result = userService.registerUser(username,
				email, password1, role, created);
		
		if(result.equals("USERNAME ALREADY USED")) {
			log.warn("Registration succeed with oid = ["+result+"]");
			model.addAttribute("registerError", result);

		}
		else if(result != null) {
			log.warn("Registration succeed with oid = ["+result+"]");
			model.addAttribute("signupSucceed", "Inscription Succeed");

		}
//		else {
//			log.warn("Registration failed for : ["+ username+"], Problem occured while registration process");
//			model.addAttribute("registerError", "Problem occured while inscription process");
//			
//		}
		return "register";
	}

}
