package vaish.niit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vaish.niit.DAO.CartDAO;
import vaish.niit.Model.Cart;


   public class CartDAOTest {
	
	static CartDAO cartDAO;
	
	 
	@BeforeClass
	public static void executefirst()
	
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("sravanthi.niit");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
		
	}
	@Ignore
	@Test
	public void testaddToCart()
	{
	Cart cartItem=new Cart();
	cartItem.setProductId(2);
	cartItem.setProductName("lakme");
	cartItem.setQuantity(2);
	cartItem.setPrice(900);
	cartItem.setStatus("NP");
	cartItem.setUsername("sai");
	


	assertTrue("Problem in adding the cartItem ",cartDAO.addToCart(cartItem));	}
		

@Ignore
	@Test
	public void getCartTest()
	{
		assertNotNull("Problem in get Category",cartDAO.getCartItem(1));
		
	}

	@Ignore
	 @Test
	public void deleteCartTest() {

		Cart cartItem=cartDAO.getCartItem(2);
		assertTrue("Problem in Deletion:",cartDAO.deleteCartItem(cartItem));
	}

	@Ignore
	@Test
	public void updateCartTest()
	{

		Cart cartItem=cartDAO.getCartItem(2);
		assertTrue("Problem in Updation",cartDAO.updateCartItem(cartItem));
	}

	/*@Test
	public void listCartItemsTest() {
		List<Cart>list=cartDAO.listCartItems("sai");
		//assertTrue("Problem Occured While Retrieving the List", cartDAO.listCartItems("sai").size()>0);
		
		for(Cart cart:cartDAO.listCartItems("sai"))
		{
			System.out.print(cartDAO.getCartItem(390)+":::");
			
		
		
	}
	}	*/
   }
		
	
	



