package vaish.niit.DAO;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vaish.niit.Model.Category;


@Repository("categoryDAO")
@Transactional

public class CategoryDAOImpl implements CategoryDAO {
	
@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().save(category);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		
	}

	}

	public boolean deleteCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().delete(category);
		return true;	
		}
		catch(Exception e)
		{
		return false;
	}
	}
	public boolean updateCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().update(category);
		return true;	
		}
		catch(Exception e)
		{
		return false;

	}

		
	}	
	
	 public Category getCategory(int categoryId) {
		
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,categoryId);
		session.close();
        return category;
	}
	
	public List<Category> listcategories() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategories=query.list();
		session.close();
		
		
		
		return listCategories;
	}

	

}


