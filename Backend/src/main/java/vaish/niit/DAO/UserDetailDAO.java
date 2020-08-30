package vaish.niit.DAO;
import vaish.niit.Model.UserDetail;

public interface UserDetailDAO {
	
	
	public boolean registerUser(UserDetail userDetail);
	
	public boolean updateUser(UserDetail userDetail);
	
    public UserDetail getUser(String userName);
	
	
	
}

