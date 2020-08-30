package vaish.niit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vaish.niit.DAO.UserDetailDAO;
import vaish.niit.Model.UserDetail;
import vaish.niit.DAO.UserDetailDAOImpl;
import static org.junit.Assert.*;

public class UserDetailDAOTest { 
	
	 static UserDetailDAO userDAO;
	 
@BeforeClass
public static void executeFirst()
	
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("vaish.niit");
	context.refresh(); 
	userDAO=(UserDetailDAO) context.getBean("userDAO");}
	
  @Test
 public void testregisterUser()
 {
	 
	 UserDetail user=new  UserDetail();
	 
	 user.setUsername("sai");
	 user.setCustomerName("sai p");
	 user.setAddress("tnagar,chennai");
	 user.setEmailId("abcdef@gmail.com");
	 user.setEnabled(true);
	 user.setMobileNo("9000000002");
	 user.setPassword("6789");
	 user.setRole("ROLE_USER");
	 
	 assertTrue("Problem in Adding User:",userDAO.registerUser(user));
	 
 }
