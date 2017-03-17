package pl.michal.service;

import java.util.List;

import pl.michal.dao.Orders;

public interface OrdersService {
	
	void sendOrder();
	List<Orders> getOrdersByInvoice();
	List<String> getInvoiceNumbers();

}
