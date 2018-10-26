package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServiceRemote {
	public int register(User user);
	public User getUserBYEmailAndPassword(String email, String password);
	public void UpdateUser(User user ,int idUser); 
	public void deleteAccount(int userId);
	public boolean validateAccount(User user);
	public void confirmAccount( int userId);
	public boolean changePassword(String oldPassword, String newPassword, User u);
	public void ForgotPasswordByMail(User user);
	public boolean changeForgotPassword(String token, String newPwd,User user);
	public boolean DesactivateAccount(User u);
	public User FindUser(int id);
	public User getFullUser(User u);
	public boolean Authenticate(String email, String pwd);
	public List<User> getAllUsers();
	public void addUserPhoto(int user_id, String photo);
}
