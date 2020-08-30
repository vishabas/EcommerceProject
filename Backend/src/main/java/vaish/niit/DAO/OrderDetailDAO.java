package vaish.niit.DAO;
import vaish.niit.Model.OrderDetail;

public interface OrderDetailDAO {
	public boolean payment(OrderDetail orderDetail);
	public boolean CartItemStatus(String username, int orderId);

}

