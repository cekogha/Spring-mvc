package fr.cekogha.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	
	@RequestMapping(value="/saveStudent", method=RequestMethod.GET)
	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	@RequestMapping(value="/students")
	public Page<Student> studentList(int page, int size)
	{
		return studentRepository.findAll(new PageRequest(page, size));
	}
	
}
