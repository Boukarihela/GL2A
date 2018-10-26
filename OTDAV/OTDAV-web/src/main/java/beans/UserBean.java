package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.print.attribute.standard.Severity;

import entities.Role;
import entities.User;
import services.UserServices;

@ManagedBean

public class UserBean {
	
	private int cin ; 
	private int id ; 
	private String Raison_sociale ; 
	private String Adresse_postale;
	private int tel; 
	private String fax; 
	private String email ; 
	private String mdp;
	private String nom ; 
	private Boolean isActif;
	private String prenom ;
	private Role role; 
	private Integer UserIdTobeUpdated; 
	//***
	
	@EJB
	UserServices us; 
	
	public void confirmUsersByAdmin(Integer id)
	{
		
		us.confirmAccount(id);
		
	}
	
	public void addUser()
	{
		int i = us.register(new User(cin, Raison_sociale, Adresse_postale, tel, fax, email, mdp, nom, prenom, role,false)); 
	System.out.println(i);
	/*	if (i ==0)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info")));
		}*/
	}
	
	
	public void deleteUser(Integer id)
	{
		us.deleteAccount(id);
	}
	
	public void UpdateUser(User u)
	{
		this.setCin(cin);
		this.setAdresse_postale(Adresse_postale);
		this.setEmail(email);
		this.setFax(fax);
		this.setIsActif(isActif);
		this.setMdp(mdp);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setRaison_sociale(Raison_sociale);
		this.setRole(role);
		
		this.setId(UserIdTobeUpdated);
		
	}
	private List<User> users ; 
	
	public List<User> getUsers()
	{
		users =us.getAllUsers();
		return users;
	}
	
	
	
	public void setUsers(List<User> users) {
		this.users = users;
	}



	public Integer getUserIdTobeUpdated() {
		return UserIdTobeUpdated;
	}

	public void setUserIdTobeUpdated(Integer userIdTobeUpdated) {
		UserIdTobeUpdated = userIdTobeUpdated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getIsActif() {
		return isActif;
	}



	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}



	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	
	public String getRaison_sociale() {
		return Raison_sociale;
	}

	public void setRaison_sociale(String raison_sociale) {
		Raison_sociale = raison_sociale;
	}

	public String getAdresse_postale() {
		return Adresse_postale;
	}

	public void setAdresse_postale(String adresse_postale) {
		Adresse_postale = adresse_postale;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

		public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	
	
	
	
}
