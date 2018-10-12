package fr.cekogha.register.service;

import java.util.List;

import fr.cekogha.register.model.User;

public interface UserService {

	String registerUser(String username, String email, String password, String role, String created);

	List<User> findAllUsers();

	List<User> findUserEntries(User user);

}