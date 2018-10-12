package fr.cekogha.register.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.cekogha.register.dao.ModelDAO;
import fr.cekogha.register.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	@Qualifier("modelDAOImpl")
	private ModelDAO<User> modelDAO;

	public UserServiceImpl() {
	}

	/* (non-Javadoc)
	 * @see fr.cekogha.register.service.UserService#registerUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */

	@Override
	public String registerUser(String username, String email, String password, String role, String created) {
		
		// Check if username is already used
		if(modelDAO.findModel(username, User.class) == null) {
		
			// Save the new User
			User user = new User(username, email, password, role, created);
			modelDAO.saveModel(user);
			
			user = modelDAO.findModel(username, User.class);

			if(log.isInfoEnabled()) {
				log.info("new User register : ["+ username+"] with : "
						+ "password = ["+password+"],"
						+ "email = ["+email+"]"
						+ "role = ["+role+"],"
						+ "created = ["+created+"]");
			}
			
			return user.getOid().toString();
		}
		
		return "USERNAME ALREADY USED";
	}


	/* (non-Javadoc)
	 * @see fr.cekogha.register.service.UserService#findAllUsers()
	 */
	@Override
	public List<User> findAllUsers() { return null; }


	/* (non-Javadoc)
	 * @see fr.cekogha.register.service.UserService#findUserEntries(fr.cekogha.register.model.User)
	 */
	@Override
	public List<User> findUserEntries(User user) { return null; }

}
