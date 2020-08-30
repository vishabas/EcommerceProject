package vaish.niit.Test;
import static org.junit.Assert.*;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vaish.niit.DAO.ProductDAOImpl;
import vaish.niit.Model.Category;
import vaish.niit.Model.Product;
import vaish.niit.DAO.ProductDAOImpl;



public class ProductTest {
	
	static ProductDAOImpl productDAO;

	@BeforeClass
	public static void executeFrist()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("vaish.niit");
		context.refresh();
		
		productDAO=( ProductDAO)context.getBean("productDAO");
	}
	
    @Test
	public void addProductTest()
	{
		Product product=new Product();
		
		product.setProductName("Lakme Lipstic");
		product.setProductDesc("");
		product.setProductId(1);
		product.setSupplierId(90);
		product.setStock(20);
		product.setCatid(1);
		
		product.setProductName(" Revlon lipstic");
		product.setProductDesc("");
		product.setProductId(1);
		product.setSupplierId(90);
		product.setStock(20);
		product.setCatid(2);
		
		assertTrue("Problem in adding the Product ",productDAO.addProduct(product));	}
	
@Ignore
@Test
public void getProductTest()
{
	assertNotNull("Problem in get Category",productDAO.getProduct(1));
	
}

@Ignore
@Test
public void deleteCategoryTest()
{
	Product product=productDAO.getProduct((1));
	assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
}

@Ignore
@Test
public void updateCategoryTest()
{
	Product product=productDAO.getProduct((2));
	assertTrue("Problem in Updation",productDAO.updateProduct(product));
}


@Ignore
@Test
public void listcategoriesTest() {

	List<Product>listProducts=productDAO.listProducts();
	assertTrue("Problem Occured While Retrieving the List",listProducts.size()>0);
	
	for(Product product:listProducts)
	{
		System.out.print(product.getProductId()+":::");
		System.out.print(product.getProductName()+":::");
		System.out.println(product.getProductDesc());
	}






}

}

