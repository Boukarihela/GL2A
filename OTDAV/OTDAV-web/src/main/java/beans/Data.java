package beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import entities.Role;

@ManagedBean
@ApplicationScoped
public class Data {

	public Role[] getRoles()
	{
		return Role.values();
	}
}
