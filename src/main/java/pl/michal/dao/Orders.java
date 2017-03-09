package pl.michal.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="zamowienia")
public class Orders extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDateTime orderDate;
	private String invoiceNr;
	private BigDecimal price;
	private Products product;
	
}
