package fr.cekogha.model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users_collection")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private ObjectId oid;
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private String birthday;
	private String role;
	private String created;
	
	public User(){}

	public User(String firstname, String lastname, String username, String email, String password, String birthday, String role,
			String created) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.role = role;
		this.created = created;
	}

	
	@Override
	public String toString() {
		return "User [ username=" + username + ", email="
				+ email + ", birthday=" + birthday + ", role=" + role + "]";
	}

	
	/*****************************/
	/**   GETTERS AND SETTERS   **/
	/*****************************/
	
	
	public ObjectId getOid() { return oid; }
	
	public void setOid(ObjectId oid) { this.oid = oid; } 
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmailname(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthay(String birthday) {
		this.birthday = birthday;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
	
	
	
}
