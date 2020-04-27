package action;



import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import dao.LoginDAO;
import dao.LoginDAOImpl;
import model.Login;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;


public class LoginAction implements Action, ModelDriven<Login>, ServletContextAware {

	private ServletContext ctx;
	private Login user = new Login();
	
	@Override
	public String execute() throws Exception {
		
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		LoginDAO userDAO = new LoginDAOImpl(sf);
		Login userDB = userDAO.getUserByCredentials(user.getName(), user.getPwd());
		if(userDB == null) return ERROR;
		else {
			user.setName(userDB.getName());
			return SUCCESS;
		}
	}
	@Override
	public void setServletContext(ServletContext sc) {
		this.ctx = sc;
	}
	@Override
	public Login getModel() {
		return user;
	}
	
}
