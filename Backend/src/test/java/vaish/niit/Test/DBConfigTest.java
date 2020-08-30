package vaish.niit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBConfigTest {
	public static void main(String[]args) {
		
		/*
		 * DBConfig da=new DBConfig(); da.getH2Datasource();
		 */
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		   context.scan("vaish.niit");
		   
		   context.refresh();	  
		   System.out.println("Configuration success");
}
}

