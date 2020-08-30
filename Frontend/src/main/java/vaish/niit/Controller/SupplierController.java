package vaish.niit.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sravanthi.niit.DAO.SupplierDAO;
import sravanthi.niit.Model.Supplier;
@Controller
public class SupplierController {
	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping("/supplier")
	public String showSupplier(Model m)
	{
		Supplier supplier=new Supplier();
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		m.addAttribute(supplier);
		m.addAttribute("supplierList",listSuppliers);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/insertSupplier",method=RequestMethod.POST)
	public String saveSupplierDetail(@RequestParam("supName")String supplierName,@RequestParam("supAddr") String supplierAddr,Model m)
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddr(supplierAddr);
		supplierDAO.addSupplier(supplier);
		
	
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		m.addAttribute("supplierList", listSuppliers);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(supplier);
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
				m.addAttribute("supplierList", listSuppliers);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/editsupplier/{supplierId}")
	public String editcategory(@PathVariable("supplierId")int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		m.addAttribute("supplier",supplier);
		return "Supplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	 public String updateSupplier(Model m,@RequestParam("supId")int supplierID,@RequestParam("supName")String supplierName,@RequestParam("supAddr")String supplierAddr)
	 {
		Supplier supplier=supplierDAO.getSupplier(supplierID);
		 supplier.setSupplierName("supplierName");
		 supplier.setSupplierAddr("supplierAddr");
		 supplierDAO.updateSupplier(supplier);
		 List<Supplier> listsuppliers= supplierDAO.listSuppliers();
		 m.addAttribute(" supplierList",listsuppliers);
		 return "Supplier";
	 }
	
