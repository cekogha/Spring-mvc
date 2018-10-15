package fr.cekogha.security.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {
	
	@Id @GeneratedValue
	private Long idStudent;
	private String firstname;
	private String lastname;
	private Date birthday;
	
	public Student(String firstname, String lastname, Date birthday) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
