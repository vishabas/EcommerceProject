package vaish.niit.Test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import Vaish.niit.DAO.SupplierDAO;

import vaish.niit.Model.Supplier;
import vaish.niit.DAO.SupplierDAOImpl;

public class SupplierDAOTest {

static SupplierDAOTest supplierDAO;
	 
	 
	@BeforeClass
	public static void executefirst()
	
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("vaish.niit");
		context.refresh();
		supplierDAO=( SupplierDAO)context.getBean("supplierDAO");
		
	}
	
@Test
public void testaddsupplier()
{
Supplier supplier=new Supplier();

supplier.setSupplierName("Nykaa");
supplier.setSupplierAddr("annanagar");
supplier.setSupplierName("Lakhme ");
supplier.setSupplierAddr("moggapair chennai"); 


assertTrue("Problem in adding the supplier ",supplierDAO.addSupplier(supplier));	}
	


@Test
public void getSupplierTest()
{
	assertNotNull("Problem in get supplier",supplierDAO.getSupplier(1));
	
}

@Ignore
 @Test
public void deleteSupplierTest() {

	Supplier supplier=supplierDAO.getSupplier(2);
	assertTrue("Problem in Deletion:",supplierDAO.deleteSupplier(supplier));
}

@Ignore
@Test
public void updateSupplierTest()
{
	Supplier supplier=supplierDAO.getSupplier(100);
	assertTrue("Problem in Updation",supplierDAO.updateSupplier(supplier));
}



@Test
public void listsuppliersTest() {

	List<Supplier>listSuppliers=supplierDAO.listSuppliers();
	assertTrue("Problem Occured While Retrieving the List",listSuppliers.size()>0);
	
	for(Supplier supplier:listSuppliers)
	{
		System.out.print(supplier.getSupplierId()+":::");
		System.out.print(supplier.getSupplierName()+":::");
		System.out.println(supplier.getSupplierAddr()+"");
}
	
	
}	
}	
	
	
	
	


