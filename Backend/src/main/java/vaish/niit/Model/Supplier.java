package vaish.niit.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier {
@Id
@GeneratedValue (strategy= GenerationType.IDENTITY)	
int
SupplierId;

String SupplierName;
String supplierAddr;
public int getSupplierId() {
	return SupplierId;
}
public void setSupplierId(int supplierId) {
	SupplierId = supplierId;
}
public String getSupplierName() {
	return SupplierName;
}
public void setSupplierName(String supplierName) {
	SupplierName = supplierName;
}
public String getSupplierAddr() {
	return supplierAddr;
}
public void setSupplierAddr(String supplierAddr) {
	this.supplierAddr = supplierAddr;
}

	
	
	
	
}

