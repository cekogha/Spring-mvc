package fr.cekogha.security;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.cekogha.security.entities.Student;
import fr.cekogha.security.entities.StudentRepository;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(SpringSecurityApplication.class, args);
		
		StudentRepository studentRepository = ctx.getBean(StudentRepository.class);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		studentRepository.save(new Student("firstname", "lastname", dateFormat.parse("2000-09-01")));
		studentRepository.save(new Student("ricky", "Sheen", dateFormat.parse("2002-10-21")));
		studentRepository.save(new Student("charlie", "Joel", dateFormat.parse("2005-07-11")));
		studentRepository.save(new Student("billy", "Martin", dateFormat.parse("2003-02-14")));
		
		List<Student> students = studentRepository.findAll();
		
		students.forEach(System.out::println);
	}
}
