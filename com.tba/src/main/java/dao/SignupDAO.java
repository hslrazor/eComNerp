package dao;

import java.util.Date;

import model.Signup;

public interface SignupDAO {
	
	//rereiv usersignup
	Signup getSignupInformation(
			String firstname,
			String lastname,
			String name,
			String pwd,
			String email,
			Date birthday,
			String gender
			);

	//insert 
	boolean insertSingupUser( Signup signupObj);
}
