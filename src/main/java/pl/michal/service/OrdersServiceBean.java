package pl.michal.service;

import java.util.List;

import javax.transaction.Transactional;

import pl.michal.dao.Cart;
import pl.michal.dao.Invoice;
import pl.michal.dao.Orders;
import pl.michal.repository.CartRepository;
import pl.michal.repository.InvoiceRepository;
import pl.michal.repository.OrdersRepository;

public class OrdersServiceBean implements OrdersService {

	private final CartRepository cartRepository;
	private final OrdersRepository ordersRepository;
	private final InvoiceRepository invoiceRepository;
	
	public OrdersServiceBean(CartRepository cartRepository, OrdersRepository ordersRepository, InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
		this.cartRepository = cartRepository;
		this.ordersRepository = ordersRepository;
	}
	
	@Transactional
	private Invoice generateNewInvoice(){
		Invoice invoice = new Invoice();
		invoice.setInvoiceNo(invoiceRepository.findLastInvoice().getInvoiceNo()+1);
		return invoice;
	}
	
	@Override
	public void sendOrder() {
		Orders newOrder = new Orders();
		Invoice newInvoice = generateNewInvoice();
		for ( Cart saveCart : cartRepository.findAllByAuthenticatedClient()){
			newOrder.setProduct(saveCart.getProduct());
			newOrder.setPrice(saveCart.getProduct().getPrice());
			newOrder.setInvoice(newInvoice);
		}
	}

	@Override
	public List<Orders> getOrdersByInvoice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getInvoiceNumbers() {
		// TODO Auto-generated method stub
		return null;
	}

}
