package dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Signup;

public class SignupDAOImpl implements SignupDAO {

	 private SessionFactory sf;
		
		public SignupDAOImpl(SessionFactory sf){
			this.sf = sf;
		}
	
	@Override
	public Signup getSignupInformation(String firstname, String lastname, String name, String pwd, String email,
			Date birthday, String gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertSingupUser(Signup signupObj) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(signupObj);
		try {
			tx.commit();
			session.close();
	        session.flush();  
	        session.close();  
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	 

}
