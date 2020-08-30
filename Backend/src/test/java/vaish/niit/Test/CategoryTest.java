package vaish.niit.Test;
import static org.junit.Assert.*;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vaish.niit.DAO.CategoryDAO;
import vaish.niit.Model.Category;
import vaish.niit.DAO.CategoryDAOImpl;


public class CategoryTest {
	
	static CategoryDAO categoryDAO;
    
	@BeforeClass
	public static void executeFrist()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("sravanthi.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		 
	} 


@Test
public void addCategoryTest() {
	
	Category category = new Category();
	
	category.setCategoryName("Nailpolishes");
	category.setCategoryDesc(" ");
	category.setCategoryName("FacePowders");
	category.setCategoryDesc(" ");
	category.setCategoryName("Lipstics");
	category.setCategoryDesc("");
	
	assertTrue("Problem in adding the Category ",categoryDAO.addCategory(category));	}
@Ignore
 @Test
	public void getCategoryTest()
	{
		assertNotNull("Problem in get Category",categoryDAO.getCategory(1));
		
	}
	@Ignore
	 @Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(1);
		assertTrue("Problem in Updation",categoryDAO.updateCategory(category));
	}
	
	
	
    @Test
   public void listcategoriesTest() {
	
		List<Category>listCategories=categoryDAO.listcategories();
		assertTrue("Problem Occured While Retrieving the List",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCategoryDesc());
		}





	
}

}

	
	
   
			
		
		
		
		
		
			
			
		
