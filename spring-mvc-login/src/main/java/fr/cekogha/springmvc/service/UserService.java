package fr.cekogha.springmvc.service;

import fr.cekogha.springmvc.model.User;

public interface UserService {

	public User loginUser(String username, String password);
}
