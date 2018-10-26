package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
// commit
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id  ; 
	
	private int cin ; 
	private String photo;
	private String lieu_carte_idendite; 
	private String Raison_sociale ; 
	private String Adresse_postale;
	private int tel; 
	private String fax; 
	private String email ; 
	private String mdp;
	private String nom ; 
	private String token;
	private AccountStatus status;
	private String prenom ;
	@Enumerated(EnumType.STRING)
	private Role role; 
	private static final long serialVersionUID = 1L;
	private static User user_instance;
	private Boolean isActif;
	//**************************************
	

	public User() {
		super();
	}



public User(int cin, String raison_sociale, String adresse_postale, int tel, String fax, String email, String mdp,
			String nom, String prenom, Role role, Boolean isActif) {
		super();
		this.cin = cin;
		Raison_sociale = raison_sociale;
		Adresse_postale = adresse_postale;
		this.tel = tel;
		this.fax = fax;
		this.email = email;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.isActif=isActif;
	}



public User(User u) {
		super();
		this.cin = u.cin;
		this.photo = u.photo;
		this.lieu_carte_idendite = u.lieu_carte_idendite;
		this.Raison_sociale =u. Raison_sociale;
		this.Adresse_postale =u. Adresse_postale;
		this.tel = u.tel;
		this.fax = u.fax;
		this.email = u.email;
		this.nom = u.nom;
		this.token = u.token;
		this.prenom = u.prenom;
		this.role = u.role;
	}

	
	
	//*********
	
	
	public User(int cin, String photo, String lieu_carte_idendite, String raison_sociale, String adresse_postale, int tel,
		String fax, String email, String mdp, String nom, String token, AccountStatus status, String prenom,
		Role role) {
	super();
	this.cin = cin;
	this.photo = photo;
	this.lieu_carte_idendite = lieu_carte_idendite;
	Raison_sociale = raison_sociale;
	Adresse_postale = adresse_postale;
	this.tel = tel;
	this.fax = fax;
	this.email = email;
	this.mdp = mdp;
	this.nom = nom;
	this.token = token;
	this.status = status;
	this.prenom = prenom;
	this.role = role;
}



	public Boolean getIsActif() {
		return isActif;
	}



	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}



	public static User getUser_instance() {
		if ( user_instance == null)
			 user_instance = new User();
		return  user_instance;
	}

	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
	}



	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static void setUser_instance(User u) {
		User.user_instance = new User(u);
	}

	
	public void Logout(){
		user_instance = null;
	}

	
	


	public AccountStatus getStatus() {
		return status;
	}



	public void setStatus(AccountStatus status) {
		this.status = status;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getLieu_carte_idendite() {
		return lieu_carte_idendite;
	}

	public void setLieu_carte_idendite(String lieu_carte_idendite) {
		this.lieu_carte_idendite = lieu_carte_idendite;
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

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
   
	
	
}
