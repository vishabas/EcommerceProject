package vaish.niit.DAO;
import java.util.List;

import vaish.niit.Model.Supplier;

public interface SupplierDAO {

	public Boolean addSupplier(Supplier supplier);
	public Boolean deleteSupplier(Supplier supplier);
    public Boolean updateSupplier(Supplier supplier);
    public List<Supplier> listSuppliers();
    public Supplier getSupplier(int SupplierId);
    
    
    
    
    
    
}

