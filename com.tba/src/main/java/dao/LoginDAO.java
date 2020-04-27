package dao;

import model.Login;

public interface LoginDAO {
	
	Login getUserByCredentials(String userId, String password);

}
