package pl.michal.dao;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="zamowienia")
public class Orders extends BaseEntity{
	
	private Date orderDate;
	private String invoiceNr;
	private BigDecimal price;
	private Products product;
	
}
