package services;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
//import org.mindrot.jbcrypt.BCrypt;
import entities.*;
import interfaces.UserServiceRemote;

@Stateless
@LocalBean
public class UserServices implements UserServiceRemote{

	
	public UserServices() {
		super();
	}


	@PersistenceContext(unitName = "OTDAV-ejb")
	private EntityManager em;

	@Override
	public  int register(User user) {
	
			/*	List existing = em.createQuery("select u "+
		                "from User u " +
		                "where u.email=:user.email " +
				"and u.mdp=:user.mdp")
						.getResultList();
		
		if (existing.size()==0)
		{*/
		
		/* String pass = BCrypt.hashpw(user.getPwd(), BCrypt.gensalt());
	        user.setPwd(pass);*/
		em.persist(user);
		//Logger.getAnonymousLogger("Registered new user ");                        
		                                 
		
	
		return user.getId();
	
		
	}
	
	@Override
	public User getUserBYEmailAndPassword(String email, String mdp)
	{
		
		
		TypedQuery<User> query = em.createQuery("select u from  User u "+
				"where u.email=:email and  "+
				"u.mdp=:mdp", User.class); 
		query.setParameter("email", email); 
		query.setParameter("mdp", mdp);
		
		User user= null; 
		try{
		user = query.getSingleResult(); 
		}
		catch (NoResultException e) {
			Logger.getAnonymousLogger("aucun user valide  avec email :"+email);
			
		}
		return user; 
	}
	
	
	
	@Override
	public void confirmAccount( int userId) {
		
		User u = em.find(User.class,userId);
			u.setIsActif(true);
			em.merge(u);
		
	}

	@Override
	public boolean changePassword(String oldPassword, String newPassword, User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ForgotPasswordByMail(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean changeForgotPassword(String token, String newPwd, User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DesactivateAccount(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User FindUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getFullUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Authenticate(String email, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		Query q = em.createQuery("select u from User u");
		List<User> l = q.getResultList();
		return l;
	}

	@Override
	public void addUserPhoto(int user_id, String photo) {
		// TODO Auto-generated method stub

		User u = em.find(User.class, user_id);
		u.setPhoto(photo);
		em.merge(u);
		
	}


	@Override
	public void UpdateUser(User user,int userId) {
		
		/*User u = em.find(User.class, userId);
			u.se
		
		em.merge(user);*/
		
	}


	@Override
	public boolean validateAccount(User user) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public void deleteAccount(int userId) {
		// TODO Auto-generated method stub
		User u = em.find(User.class,userId);
		em.remove(u);
	}


	public String encrypt(String password) {
		String crypte = "";
		for (int i = 0; i < password.length(); i++) {
			int c = password.charAt(i) ^ 48;
			crypte = crypte + (char) c;
		}
		// System.out.println("token: " + crypte);
		return crypte;
	}

	public static String decrypt(String password) {
		String aCrypter = "";
		for (int i = 0; i < password.length(); i++) {
			int c = password.charAt(i) ^ 48;
			aCrypter = aCrypter + (char) c;
		}
		// System.out.println("token: " + aCrypter);
		return aCrypter;
	}
	

	

}
