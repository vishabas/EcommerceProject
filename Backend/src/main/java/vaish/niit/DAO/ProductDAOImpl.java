package vaish.niit.DAO;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vaish.niit.Model.Product;
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	@Autowired
		SessionFactory sessionFactory; 
		 public boolean deleteProduct(Product product) 
		{
			try
			{
			sessionFactory.getCurrentSession().delete(product);
			return true;	
			}
			catch(Exception e)
			{
			return false;
			}
		}

		
		public boolean updateProduct(Product product) 
		{
			try
			{
			sessionFactory.getCurrentSession().update(product);
			return true;	
			}
			catch(Exception e)
			{
			return false;
			}
			
		}
		
		public List< Product> listProducts() 
		{
			Session session=sessionFactory.openSession();
			List<Product>listProducts=(List<Product>)session.createQuery("from Product").list();
			session.close();
			return  listProducts;
		}
	

			public Product getProduct(int productId) {
		
			Session session=sessionFactory.openSession();
			Product product=(Product)session.get(Product.class,productId);
			session.close();
			return product;
		
			}



			public boolean addProduct(Product product) {
				
					try
					{
					sessionFactory.getCurrentSession().save(product);
					return true;	
					}
					catch(Exception e)
					{
				return false;
			}
		

			}
}