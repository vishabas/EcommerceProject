package vaish.niit.Model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class OrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int orderId;
	String username;
	Date orderDate;
	double totalShippingAmount;
	String pmode;
	private Object orderdetailId;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int oderId, Object orderdetailId) {
		this.orderdetailId = orderdetailId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date oderDate) {
		this.orderDate = oderDate;
	}
	public double getTotalShippingAmount() {
		return totalShippingAmount;
	}
	public void setTotalShippingAmount(double total_Amount) {
		this.totalShippingAmount = total_Amount;
	}
	public String getPmode() {
		return pmode;
	}
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}
	
	}

