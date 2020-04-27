package dao;

import model.Login;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LoginDAOImpl implements  LoginDAO {
	
	
    private SessionFactory sf;
	
	public LoginDAOImpl(SessionFactory sf){
		this.sf = sf;
	}

	@Override
	public Login getUserByCredentials(String userId, String password) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Login where userName=:name and userpass=:pwd");
		query.setString("name", userId); query.setString("pwd", password);
		Login login = (Login) query.uniqueResult();
		if(login != null){
			System.out.println("User Retrieved from DB::"+login);
		}
		tx.commit();session.close();
		return login;
	}

}
