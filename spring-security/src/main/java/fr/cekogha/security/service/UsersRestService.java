package fr.cekogha.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cekogha.security.entities.Role;
import fr.cekogha.security.entities.RoleRepository;
import fr.cekogha.security.entities.UserRepository;
import fr.cekogha.security.entities.Users;

@RestController
@Secured(value= {"ROLE_ADMIN"})
public class UsersRestService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping (value="/addUser")
	public Users save(Users u)
	{
		return userRepository.save(u);	
	}
	
	@RequestMapping(value="/findUsers")
	public List<Users> findUsers()
	{
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/addRole")
	public Role save(Role r)
	{
		return roleRepository.save(r);	
	}

	@RequestMapping(value="/findRoles")
	public List<Role> findRoles()
	{
		return roleRepository.findAll();
	}
	
	@RequestMapping(value="/addRoleToUser")
	public Users addRoleToUser(String username, String role)
	{
		Optional<Users> u = userRepository.findById(username);
		Optional<Role> r = roleRepository.findById(role);
		
		if(u.get() instanceof Users && r.get() instanceof Role) {
			u.get().getRoles().add(r.get());
		
			userRepository.save(u.get());
		}
		
		return u.get();
	}
	
}
