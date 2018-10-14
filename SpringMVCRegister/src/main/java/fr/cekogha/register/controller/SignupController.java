package fr.cekogha.register.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.cekogha.register.service.UserService;
import fr.cekogha.register.utils.LogUtils;

@Controller
public class SignupController {

	private static Logger logger = LoggerFactory.getLogger(SignupController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private LogUtils logUtils;

	private List<String> listAttemptRegister = new ArrayList<String>();

	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String userInscription(@RequestParam String username, @RequestParam String email,
			@RequestParam String password1,	Model model) {

		logUtils.printLog_register(logger, 1, username + " - " + email);
		
		String created = LocalDate.now().toString();
		String role = "GAMER";
		String attemptRegistration = username + " - " + email + " - " + password1;

		if(!listAttemptRegister.contains(attemptRegistration)) {

			listAttemptRegister.add(attemptRegistration);
			
			String result = userService.registerUser(username,
					email, password1, role, created);

			if(result.equals("USERNAME ALREADY USED")) {

				logUtils.printLog_register(logger, 4, username);

				model.addAttribute("registerError", result);

			}
			else if(result != null) {

				logUtils.printLog_register(logger, 2, result);

				model.addAttribute("registerSucceed", "Inscription Succeed");

			}
		
		}
		else{

			logUtils.printLog_register(logger, 3, username + " - " + email);
			
		}
		
		return "register";
	}

}
