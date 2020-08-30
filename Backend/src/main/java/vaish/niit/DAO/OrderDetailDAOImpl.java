package vaish.niit.DAO;
import javax.persistence.criteria.Order;
import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import vaish.niit.Model.OrderDetail;
@Repository("orderDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO{
	
@Autowired
SessionFactory sessionFactory;

	public boolean payment(OrderDetail orderDetail) {
		try
		{
		sessionFactory.getCurrentSession().save(orderDetail);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean CartItemStatus(String username, int orderId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Cart set status ='p',orderId=:ordId where username=:uname and status= 'NP'");
		query.setParameter("ordId", orderId);
		query.setParameter("uname",username);
		
		int row_eff=query.executeUpdate();
		if( row_eff>0) 
			
			return true;
		else
			return false;
		}

}
