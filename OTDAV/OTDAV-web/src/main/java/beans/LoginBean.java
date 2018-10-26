package beans;


import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.User;
import services.UserServices;


@ManagedBean
@SessionScoped
public class LoginBean {

	
	private String login ; 
	private String password ; 
	
	private User user; 
	private boolean loggedIn; 
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	@EJB
	UserServices us; 
	public String doLogin() 
	{
		String navigatTO="null"; 
		
		user= us.getUserBYEmailAndPassword(login, password); 
		if (user!=null && user.getRole() == entities.Role.admin)
		{
			navigatTO= "/pages/admin/listUsers?faces-redirect=true"; 
			loggedIn=true; 
		}
		else 
		{
			FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage("bad credentials"));
		}
		
		return navigatTO; 
	}
	
	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true"; 
	}
	
}
