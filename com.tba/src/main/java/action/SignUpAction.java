package action;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import dao.SignupDAO;
import dao.SignupDAOImpl;
import model.Signup;


public class SignUpAction implements Action, ModelDriven<Signup>, ServletContextAware
{
	private ServletContext ctx;
	private Signup signupuser = new Signup();
	
	String firstname;
	String lastname;
	String name;
	String pwd;
	String email;
	Date birthday;
	String gender;
	
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;  
	 
	}
	@Override
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.ctx = context;
	}
	@Override
	public Signup getModel() {
		return signupuser;
	}
	
	private void signupUserfill() {
		signupuser.setFirstname(this.firstname);
		signupuser.setLastname(this.lastname);
		signupuser.setName(this.name);
		signupuser.setPwd(this.pwd);
		signupuser.setEmail(this.email);
		signupuser.setBirthday(this.birthday);
		signupuser.setGender(this.gender);
	}
	
	public String signup(){         
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		if(signupuser.getName().isBlank())
			return SUCCESS;
		else {			
			SignupDAO signDAO = new SignupDAOImpl(sf);
			boolean userInfo = signDAO.insertSingupUser(getModel());
			if (userInfo == false) return ERROR;
			else {
				System.out.println("Data saved");
				return SUCCESS;
			}
		}
    }  
 

}
