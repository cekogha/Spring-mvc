package fr.cekogha.springmvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.cekogha.springmvc.dao.ModelDAO;
import fr.cekogha.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	@Qualifier("modelDAOImpl")
	private ModelDAO<User> modelDAO;

	public User loginUser(String username, String password) {
		// TODO Auto-generated method stub
		User user = modelDAO.findModel(username, User.class);

		if(user != null && password.equals(user.getPassword())){
			return user;
		}
		return null;
	}

}
