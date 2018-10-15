package fr.cekogha.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.cekogha.dao.ModelDAO;
import fr.cekogha.model.User;

@Service("userService")
@Transactional
public class UserService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	@Qualifier("modelDAOImpl")
	private ModelDAO<User> modelDAO;

	public UserService() {
	}

	/**************************/
	/** 1 - BUSINESS METHODS **/
	/**************************/

	public User loginUser(String username, String password) {
		// TODO Auto-generated method stub
		User user = modelDAO.findModel(username, User.class);

		if(user != null && password.equals(user.getPassword())){
			return user;
		}
		return null;
	}

	public ObjectId createUser(String firstname, String lastname, String username, String email, String password, String birthname, String role, String created) {
		User user = new User(firstname, lastname, username, email, password, birthname, role, created);
		modelDAO.saveModel(user);
		user = modelDAO.findModel(username, User.class);
		return user.getOid();
	}

	public ObjectId createUserWithJson() {
		//		userDAO.saveUser(objectMapper)
		return null;
	}

	/**************************/
	/** 2 -   BASIC METHODS  **/
	/**************************/

	public void deleteUser(User user) {  }


	public User findUser(Long userId) {	return null; }


	public User findUser(String username) { return null; }


	public List<User> findAllUsers() { return null; }


	public List<User> findUserEntries(User user) { return null; }


	public void saveUser(User user) {}


	public void updateUser(User user) {}

}
