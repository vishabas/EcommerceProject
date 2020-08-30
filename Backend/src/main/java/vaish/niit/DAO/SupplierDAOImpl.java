package vaish.niit.DAO;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vaish.niit.Model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
 
	@Autowired
	SessionFactory sessionFactory;
	
	
	public Boolean addSupplier(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().save(supplier);
		return true;	
		}
		catch(Exception e)
		{
		
		return false;}
		}
	

	public Boolean deleteSupplier(Supplier supplier) {
		
		try
		{
		sessionFactory.getCurrentSession().delete(supplier);
		return true;	
		}
		catch(Exception e)
		{
		
		return false;}
		}
	

	public Boolean updateSupplier(Supplier supplier) {
		
		try
		{
		sessionFactory.getCurrentSession().update(supplier);
		return true;	
		}
		catch(Exception e)
		{
		
		return false;}
		}
	

	public List<Supplier> listSuppliers() {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> listSuppliers=query.list();
		session.close();
	  return listSuppliers;
	}

	public Supplier getSupplier(int SupplierId) {
		
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,SupplierId);
		session.close();
        return supplier;
	}

}
