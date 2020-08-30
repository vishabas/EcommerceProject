package vaish.niit.DAO;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vaish.niit.Model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDetailDAO{
	
@Autowired
SessionFactory sessionFactory;
	
	public boolean registerUser(UserDetail userDetail) {
		try
		{
			sessionFactory.getCurrentSession().save(userDetail);
		return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	public boolean updateUser(UserDetail userDetail) {
		try
		{
			sessionFactory.getCurrentSession().update(userDetail);
		return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}
	public UserDetail getUser(String username) {
		Session session=sessionFactory.openSession();
		UserDetail user=(UserDetail)session.get(UserDetail.class, username);
		session.close();
		
		return user;}

	}