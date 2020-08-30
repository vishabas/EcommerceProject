package vaish.niit.DAO;
import java.util.List;

import vaish.niit.Model.Product;



public interface ProductDAO{
	
	
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product );
	public boolean updateProduct(Product  product );
	public Product getProduct(int productId);
	public List<Product> listProducts();
}
	



