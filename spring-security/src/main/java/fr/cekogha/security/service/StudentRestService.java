package fr.cekogha.security.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.cekogha.security.entities.Student;
import fr.cekogha.security.entities.StudentRepository;

/*
 * If you use MVC client-side, you will use RestController
 * if you use MVC server-side, you will use Controller
 * 
 * */

@RestController
public class StudentRestService {

	@Autowired
	private StudentRepository studentRepository;

	@Secured(value= {"ROLE_ADMIN", "ROLE_SCHOOLING"})	
	@RequestMapping(value="/saveStudent", method=RequestMethod.POST)
	public Object saveStudent(@RequestBody @Valid Student student, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) {
			Map<String, Object> errors = new HashMap<>();
			errors.put("errors", true);
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			
			return errors;
		}
		return studentRepository.save(student);
	}

	@Secured(value= {"ROLE_ADMIN", "ROLE_SCHOOLING", "ROLE_STUDENT", "ROLE_PROF"})
	@RequestMapping(value="/students")
	public Page<Student> studentList(int page, int size)
	{
		return studentRepository.findAll(PageRequest.of(page, size));
	}
	
	
	@RequestMapping(value="/getLoggedUser")
	public Map<String, Object> getLoggedUser(HttpSession httpSession)
	{
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");

		String username = securityContext.getAuthentication().getName();
		
		List<String> roles = new ArrayList<String>();

		for( GrantedAuthority ga : securityContext.getAuthentication().getAuthorities())
		{
			roles.add(ga.getAuthority());
		}
		
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);
		
		return params;
	}
	
//	OR
	
//	@RequestMapping(value="/getLoggedUser")
//	public Map<String, Object> getLoggedUser(HttpServletRequest httpServletRequest)
//	{
//		HttpSession session = httpServletRequest.getSession();
//		...
//		
//	}
	
}
